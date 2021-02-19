package imob.innovation.model.valueObject;

import imob.innovation.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListaDeServicos {

	private int idCliente;
	private Servico servico[];
}
