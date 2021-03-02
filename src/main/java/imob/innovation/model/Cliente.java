package imob.innovation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Cliente {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Column
	private String nomeCliente;
	
	@Column
	private String enderecoCliente;
	@Column
	private String telefoneCelular;
	@Column
	private String email;
	@Column
	private String senha;
	private boolean ativado;
	private boolean desativado;
	
	private List<Servico> servicos;
}
