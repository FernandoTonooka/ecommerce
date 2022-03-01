
package controller;

import domain.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand {
    
    @Override
    public String execute(EntidadeDominio entidade) {
		
	return fachada.excluir(entidade);
	
    }
}
