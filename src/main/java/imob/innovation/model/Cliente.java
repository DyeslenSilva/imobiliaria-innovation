package imob.innovation.model;

import java.util.List;

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
	
	private String nomeCliente;
	
	private String enderecoCliente;
	private String telefoneCelular;
	private String email;
	private String senha;
	private boolean ativado;
	private boolean desativado;
	
	private List<Servico> servicos;
}
