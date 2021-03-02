package imob.innovation.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Interesse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteresse;
	
	private String nome,endereco, telefone, mensagem;
	private boolean ativo;
}
