
package controller;

import domain.EntidadeDominio;

public class SalvarCommand extends AbstractCommand {
    
    @Override
    public String execute(EntidadeDominio entidade) {	
        
		return fachada.salvar(entidade);
    
    }
}    
