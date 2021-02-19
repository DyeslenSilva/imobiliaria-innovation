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
	
	public ResponseEntity<Object> cadastroFuncionario(@RequestBody Funcionario funcionario){
		funcionarioService.salvarFuncionario(funcionario);
		return ResponseEntity.ok().build();
	}
	
	
}
