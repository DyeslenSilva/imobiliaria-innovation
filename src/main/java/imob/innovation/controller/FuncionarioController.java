package imob.innovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imob.innovation.model.Funcionario;
import imob.innovation.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarioAPI")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping("/cadastraFuncionario")
	public ResponseEntity<Object> cadastroFuncionario(@RequestBody Funcionario funcionario){
		funcionarioService.salvarFuncionario(funcionario);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaDeFuncionarios")
	public ResponseEntity<Object> getFuncionarios(){
		return ResponseEntity.ok(funcionarioService.getFuncionarios());
	}
	
	@RequestMapping("/buscarFuncionario/{idFuncionario}")
	public ResponseEntity<Object> getFuncionarioPorID(@RequestBody Integer idFuncionario){
		funcionarioService.getFuncionario(idFuncionario);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editarFuncionario/{idFuncionario}")
	public ResponseEntity<Object> editaFuncionario(@RequestBody Integer idFuncionario){
		Funcionario funcionario = funcionarioService.getFuncionario(idFuncionario);
		if(funcionario !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	
	
	
	
}
