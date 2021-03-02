package imob.innovation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imob.innovation.model.Interesse;
import imob.innovation.service.InteresseService;

@RestController
@RequestMapping("/interesseAPI")
public class InteresseController {

	@Autowired
	private InteresseService interesseService;
	
	@RequestMapping("/salvarInteresse")
	public ResponseEntity<Object> salvarInteresse(@RequestBody Interesse interesse){
		interesseService.save(interesse);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/interesses")
	public ResponseEntity<List<Interesse>> getInteresse(){
		return ResponseEntity.ok(interesseService.getInteresses());
	}
	
	@RequestMapping("/encontrarInteresse/{idInteresse}")
	public ResponseEntity<Object> getInteresseByID(@PathVariable Integer idInteresse){
		interesseService.getInteresse(idInteresse);
		return ResponseEntity.ok().build();
	}
}
