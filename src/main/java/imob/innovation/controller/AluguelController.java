package imob.innovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imob.innovation.model.Aluguel;
import imob.innovation.service.AluguelService;

@RestController
@RequestMapping("/aluguelAPI")
public class AluguelController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@RequestMapping("/cadastraAluguel")
	public ResponseEntity<Object> cadastraAluguel(@RequestBody Aluguel aluguel){
		aluguelService.cadastroAluguel(aluguel);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaDeAlugueis")
	public ResponseEntity<Object> getAlugueis(){
		return ResponseEntity.ok(aluguelService.getAlugueis());
	}
	
	@RequestMapping("/encontrarAluguel/{idAluguel}")
	public ResponseEntity<Object> getAluguel(@PathVariable Integer idAluguel){
		aluguelService.getAluguel(idAluguel);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editaAluguel/{idAluguel}")
	public ResponseEntity<Object> editaAluguel(@PathVariable Integer idAluguel){
		Aluguel aluguel = aluguelService.getAluguel(idAluguel);
		if(aluguel !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping("/deleteAlguel")
	public ResponseEntity<Object> deleteAluguel(Integer[]lista){
		aluguelService.apagarAluguel(lista);
		return ResponseEntity.ok().build();
	}
	
}
