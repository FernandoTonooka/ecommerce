
package business;

import domain.EntidadeDominio;
import java.util.Date;

public class ComplementarDtCadastro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {			
		
		if(entidade !=null){
			Date data = new Date();		
			((EntidadeDominio)entidade).setDtCadastro(data);
		}else{
			return "Entidade: "+entidade.getClass().getCanonicalName()+" nula!";
		}
		return null;
	}
}