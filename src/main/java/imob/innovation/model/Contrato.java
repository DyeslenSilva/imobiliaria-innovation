package imob.innovation.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Contrato extends Cliente {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContrato;
	
	@Column
	private String tipoContrato;
	
	@Column
	private double valorContrato;
}
