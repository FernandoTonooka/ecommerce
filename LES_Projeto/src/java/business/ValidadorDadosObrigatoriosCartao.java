

package business;

import domain.Cartao;
import domain.EntidadeDominio;
import java.time.LocalDate;

public class ValidadorDadosObrigatoriosCartao implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Cartao){
			Cartao cartao = (Cartao)entidade;
			
			String nome = cartao.getNome();
			String numero = cartao.getNumero();
                        LocalDate validade = cartao.getValidade();
			
			StringBuilder sb = new StringBuilder();
			if(nome == null || numero==null || validade==null){
				sb.append("Nome, Número e Validade são de preenchimento obrigatório!");
			}else if(nome.trim().equals("") || numero.trim().equals("") || validade.equals("")){
				sb.append("Nome, Número e Validade são de preenchimento obrigatório!");
			}
                        if(sb.length()>0) {
				return sb.toString();
			}else {
				return null;
			}
			
		}else{
			return "Deve ser registrado um cartão!";
		}
	}
}
