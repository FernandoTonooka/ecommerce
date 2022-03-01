
package controller;

import domain.EntidadeDominio;

public interface ICommand {
    
    public Object execute(EntidadeDominio entidade);
    
}
