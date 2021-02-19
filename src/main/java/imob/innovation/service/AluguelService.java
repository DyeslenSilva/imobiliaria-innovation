package imob.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imob.innovation.model.Aluguel;
import imob.innovation.repo.AluguelRepo;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepo aluguelRepo;

	public void cadastroAluguel(Aluguel aluguel) {
		aluguelRepo.save(aluguel);
	}
	
	public List<Aluguel> getAlugueis(){
		return aluguelRepo.findAll().stream()
				.filter(aluguel -> aluguel.isDesativado())
				.collect(Collectors.toList());
	}
	
	public Aluguel getAluguel(Integer idAluguel) {
		return aluguelRepo.findById(idAluguel).orElse(null);
	}
	
	public void apagarAluguel(Integer [] listaAluguel) {
		Arrays.stream(listaAluguel).forEach(idAluguel ->{
			Aluguel aluguel = getAluguel(idAluguel);
			if(aluguel!=null) {
				aluguel.setDesativado(true);
				aluguelRepo.save(aluguel);
			}
		});
	}
	
	
}
