
package controller;

import domain.EntidadeDominio;

public class AlterarCommand extends AbstractCommand {
    
    @Override
    public String execute(EntidadeDominio entidade) {		
		
        return fachada.alterar(entidade);
    }
}
