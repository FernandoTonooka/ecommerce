
package business;

import dao.ClienteDAO;
import dao.IDAO;
import domain.Cliente;
import domain.EntidadeDominio;
import java.util.List;

public class ValidadorExistenciaCliente implements IStrategy {

        @Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		IDAO dao = new ClienteDAO();
		
		List<EntidadeDominio> clientes = dao.consultar(cliente);
		
		if(clientes != null) {
			return "Cliente já cadastrado!";
		}
		return null;
	}
}
