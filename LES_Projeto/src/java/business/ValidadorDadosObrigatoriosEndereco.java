
package business;

import domain.Endereco;
import domain.EntidadeDominio;

public class ValidadorDadosObrigatoriosEndereco implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Endereco){
			Endereco endereco = (Endereco)entidade;
			
			String tpResidencia = endereco.getTpResidencia();
			String tpLogradouro = endereco.getTpLogradouro();
                        String cep = endereco.getCep();
                        String logradouro = endereco.getLogradouro();
			String numero = endereco.getNumero();
                        String bairro = endereco.getBairro();
                        String cidade = endereco.getCidade().getDescricao();
                        String estado = endereco.getCidade().getEstado().getDescricao();
                        String pais = endereco.getCidade().getEstado().getPais().getDescricao();
                        
			StringBuilder sb = new StringBuilder();
			if(tpResidencia == null || tpLogradouro==null || cep==null || logradouro==null || numero==null || bairro==null || cidade==null || estado==null || pais==null){
				sb.append("Tipo de Residência, Tipo de Logradouro, CEP, Logradouro, Número, Bairro, Cidade, Estado e País são de preenchimento obrigatório!");
			}else if(tpResidencia.trim().equals("") || tpLogradouro.trim().equals("") || cep.trim().equals("") || logradouro.trim().equals("") || numero.trim().equals("") || bairro.trim().equals("") || cidade.trim().equals("") || estado.trim().equals("") || pais.trim().equals("")){
				sb.append("Tipo de Residência, Tipo de Logradouro, CEP, Logradouro, Número, Bairro, Cidade, Estado e País são de preenchimento obrigatório!");
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
			return "Deve ser registrado um endereço!";
		}
	}
    
}
