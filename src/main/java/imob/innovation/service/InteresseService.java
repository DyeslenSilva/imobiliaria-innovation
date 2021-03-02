package imob.innovation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import imob.innovation.model.Interesse;
import imob.innovation.repo.InteresseRepo;

@Service
public class InteresseService {

	private InteresseRepo interesseRepo;
	
	public void save(Interesse interesse) {
		interesseRepo.save(interesse);
	}
	
	public List<Interesse> getInteresses(){
		return interesseRepo.findAll().stream()
				.filter(interesse -> interesse.isAtivo())
				.collect(Collectors.toList());
	}
	
	public Interesse getInteresse(Integer idInteresse) {
		return interesseRepo.findById(idInteresse).orElse(null);
	}
}
