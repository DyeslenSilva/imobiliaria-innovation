package imob.innovation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFuncionario;
	
	@Column
	private String nomedoFuncionario;
	
	@Column
	private String rg;
		
	@Column
	private String cpf;
	
	@Column
	private String endereco;
	
	
	@Column
	private String senha;
	
	private boolean ativado;
	private boolean desativado;
}
