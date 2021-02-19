package imob.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imob.innovation.model.Funcionario;
import imob.innovation.repo.FuncionarioRepo;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepo funcionarioRepo;
	
	public void salvarFuncionario(Funcionario funcionario) {
		funcionarioRepo.save(funcionario);
	}
	
	public List<Funcionario> getFuncionarios(){
		return funcionarioRepo.findAll().stream()
				.filter(funcionario -> !funcionario.isDesativado())
				.collect(Collectors.toList());
	}
	
	public Funcionario getFuncionario(Integer idFuncionario) {
		return funcionarioRepo.findById(idFuncionario).orElse(null);
	}
	
	public void removeFucionario(Integer [] listaFuncionario) {
		Arrays.stream(listaFuncionario).forEach(idFuncionario ->{
			Funcionario funcionario = getFuncionario(idFuncionario);
			if(funcionario !=null) {
				funcionario.setDesativado(true);
				funcionarioRepo.save(funcionario);
			}
		});
	}
}
