
package business;

import domain.Cliente;
import domain.EntidadeDominio;

public class ValidadorDadosObrigatoriosCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Cliente){
			Cliente cliente = (Cliente)entidade;
			
			String nome = cliente.getNome();
			//String logradouro = aluno.getEndereco().getLogradouro();
			String cpf = cliente.getCpf();
			
			StringBuilder sb = new StringBuilder();
			if(nome == null || cpf==null){
				sb.append("Nome e CPF são de preenchimento obrigatório!");
			}else if(nome.trim().equals("") || cpf.trim().equals("")){
				sb.append("Nome, CPF são de preenchimento obrigatório!");
			}
			
			/*ValidadorEndereco vEnd = new ValidadorEndereco();
			String msgEnd = vEnd.processar(cliente.getEndereco());
			if(msgEnd != null) {
				sb.append(msgEnd);
			}*/
			
			if(sb.length()>0) {
				return sb.toString();
			}else {
				return null;
			}
			
		}else{
			return "Deve ser registrado um cliente!";
		}
	}
}
