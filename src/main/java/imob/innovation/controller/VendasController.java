package imob.innovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imob.innovation.model.Vendas;
import imob.innovation.service.VendasService;

@RestController
@RequestMapping("/vendasAPI")
public class VendasController {

	@Autowired
	private VendasService vendasService;
	
	@RequestMapping("/cadastrarVenda")
	public ResponseEntity<Object> registroVendas(@RequestBody Vendas vendas){
		vendasService.cadastrarVendas(vendas);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listarVendas")
	public ResponseEntity<Object> getVendas(){
		return ResponseEntity.ok(vendasService.getVendas());
	}
	
	@RequestMapping("/encontrarVenda/{idVenda}")
	public ResponseEntity<Object> getVenda(@RequestBody Integer idVenda){
		vendasService.getVenda(idVenda);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/alterarVenda/{idVenda}")
	public ResponseEntity<Object> alterarVenda(@RequestBody Integer idVenda){
		Vendas vendas = vendasService.getVenda(idVenda);
		if(vendas !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteVenda")
	public ResponseEntity<Object> deleteVenda(@RequestBody Integer[]lista){
		vendasService.apagarVenda(lista);
		return ResponseEntity.ok().build();
	}
}
