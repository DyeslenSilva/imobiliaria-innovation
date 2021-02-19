package imob.innovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imob.innovation.model.Imovel;
import imob.innovation.service.ImovelService;

@RestController
@RequestMapping("imovelAPI")
public class ImovelController {

	@Autowired
	private ImovelService imovelService;
	
	@RequestMapping("/cadastrarImovel")
	public ResponseEntity<Object> cadastrarImovel(@RequestBody Imovel imovel){
		imovelService.salvarImovel(imovel);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaDeImoveis")
	public ResponseEntity<Object> getImoveis(){
		return ResponseEntity.ok(imovelService.getImoveis());
	}
	
	@RequestMapping("/encontrarImoveis/{idImovel}")
	public ResponseEntity<Object> getImovelPorId(@RequestBody Integer idImovel){
		imovelService.getImovel(idImovel);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editarImovel/{idImovel}")
	public ResponseEntity<Object> editaImovel(@RequestBody Integer idImovel){
		Imovel imovel = imovelService.getImovel(idImovel);
		if(imovel != null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
