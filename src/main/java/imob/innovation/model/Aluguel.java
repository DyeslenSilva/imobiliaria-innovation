package imob.innovation.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Aluguel extends Contrato{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAluguel;

	private String nomeProprietario;
	
	private String nomeLocador;
	
	
	@Column
	private double valorAluguel;
	
	private String status;
	
	private String periodoAluguel;
	
	private boolean ativado;
	private boolean desativado;
}
