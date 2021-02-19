package imob.innovation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Imovel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idImovel;
	
	@Column
	private String tipoImovel;
	
	@Column
	private String proprietario;
	@Column
	private String endereco;
	@Column
	private double valorImovel;
	@Column
	private double valorAluguel;
	
	private boolean disponivel;
}
