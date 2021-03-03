package imob.innovation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import imob.innovation.model.Cliente;
import imob.innovation.model.valueObject.ListaDeServicos;
import imob.innovation.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@RequestMapping("/cadastroCliente")
	public ResponseEntity<Cliente> cadastraCliente(@RequestBody Cliente cliente){
		clienteService.save(cliente);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaClientes")
	public ResponseEntity<List<Cliente>> getClientes(){
		return ResponseEntity.ok(clienteService.getClientes());
	}
	
	
	@RequestMapping("/encontraCliente/{idCliente}")
	public ResponseEntity<Cliente> getClientePorId(@PathVariable Integer idCliente){
		 clienteService.getCliente(idCliente);
		 return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editaCliente/{idCliente}")
	public ResponseEntity<Cliente> editaCliente(@PathVariable Integer idCliente){
		Cliente cliente = clienteService.getCliente(idCliente);
		if(cliente !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteCliente")
	public ResponseEntity<Object> deleteCliente(@PathVariable int[]lista){
		clienteService.removeCliente(lista);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/selecionaServico/")
	public ResponseEntity<Cliente> selecionaServico(@RequestBody ListaDeServicos listaDeServicos){
		Cliente cliente = clienteService.getCliente(listaDeServicos.getIdCliente());
		if(cliente!=null) {
			if(cliente.getServicos()==null) {
				cliente.setServicos(new ArrayList<>());
			
				Predicate<imob.innovation.model.Servico> naoEstaNaLista = (srvCliente) -> !Arrays.stream(listaDeServicos.getServico())
						.filter(srvDaLista -> srvDaLista.getIdServico() == srvCliente.getIdServico())
						.findFirst().get().isSelecionado();
				
				
				List<imob.innovation.model.Servico> aDeletar = cliente.getServicos().stream()
						.filter(naoEstaNaLista).collect(Collectors.toList());
			
				aDeletar.stream().forEach(servico -> cliente.getServicos()
						.removeIf(srv -> srv.getIdServico() == servico.getIdServico()));
			
				
				Arrays.stream(listaDeServicos.getServico()).filter(imob.innovation.model.Servico :: isSelecionado)
					.filter(servico -> !cliente.getServicos().contains(servico))
					.forEach(servico -> cliente.getServicos().add(servico));
				
				clienteService.save(cliente);
				
				return ResponseEntity.ok().build();
			}else {
				return ResponseEntity.badRequest().build();
			}
		}
		return null;
	}
	
	
	

}
