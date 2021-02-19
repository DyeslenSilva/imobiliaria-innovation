package imob.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imob.innovation.model.Imovel;
import imob.innovation.repo.ImovelRepo;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepo imovelRepo;
	
	public void salvarImovel(Imovel imovel) {
		imovelRepo.save(imovel);
	}
	
	public List<Imovel> getImoveis(){
		return imovelRepo.findAll().stream()
				.filter(imovel -> !imovel.isDisponivel())
				.collect(Collectors.toList());
	}
	
	public Imovel getImovel(Integer  idImovel) {
		return imovelRepo.findById(idImovel).orElse(null);
	}
	
	public void removeImovel(Integer [] imovel)  {
		Arrays.stream(imovel).forEach(idImovel ->{
			Imovel imovelImovel = getImovel(idImovel);
			if(imovelImovel !=null) {
				imovelImovel.setDisponivel(true);
				imovelRepo.save(imovelImovel);
			}
		});
	}
	
}
