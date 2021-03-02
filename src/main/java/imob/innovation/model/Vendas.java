package imob.innovation.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Vendas extends Contrato{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVendas;
	
	private String nomeDoCliente;
	private String endereco;
	private String rg,cpf;
	
	@Column
	private double valorParcela;
	
	@Column
	private int quantidadeDeParcelas;
	
	@Column
	private double valorEntrada;

	
}
