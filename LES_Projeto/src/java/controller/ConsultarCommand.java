
package controller;

import domain.EntidadeDominio;
import java.util.List;

public class ConsultarCommand extends AbstractCommand {
    
    @Override
    public List<EntidadeDominio> execute(EntidadeDominio entidade) {
		
		return fachada.consultar(entidade);
	
    }
}
