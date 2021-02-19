package imob.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imob.innovation.model.Vendas;
import imob.innovation.repo.ContratosRepo;
import imob.innovation.repo.VendasRepo;

@Service
public class VendasService {

	private VendasRepo vendasRepo;
	
	public void cadastrarVendas(Vendas vendas) {
		vendasRepo.save(vendas);
	}
		
	public List<Vendas> getVendas(){
		return vendasRepo.findAll().stream()
				.filter(vendas -> !vendas.isAtivado())
				.collect(Collectors.toList());
	}
	
	public Vendas getVenda(Integer idVenda) {
		return vendasRepo.findById(idVenda).orElse(null);
	}
	
	public void apagarVenda(Integer [] vendas) {
		Arrays.stream(vendas).forEach(idVendas ->{
			Vendas vendasVendas = getVenda(idVendas);
			if(vendasVendas!=null) {
				vendasVendas.setDesativado(true);
				vendasRepo.save(vendasVendas);
			}
		});
	}
}
