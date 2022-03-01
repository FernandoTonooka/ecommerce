//FALTA COMPLETAR REGRA DE NEGÓCIO + DISCIPLINAS E CURSO + EXCLUIR/ALTERAR/CONSULTAR
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import business.ComplementarDtCadastro;
import business.IStrategy;
import business.ValidadorCpf;
import business.ValidadorDadosObrigatoriosCartao;
import business.ValidadorDadosObrigatoriosCliente;
import business.ValidadorDadosObrigatoriosEndereco;
import business.ValidadorExistenciaCliente;
import dao.CartaoDAO;
import dao.IDAO;
import dao.ClienteDAO;
import dao.EnderecoDAO;
import domain.Cartao;
import domain.Endereco;
import domain.EntidadeDominio;
import domain.Cliente;


public class Fachada implements IFachada {
    
	private Map<String, IDAO> daos;//Map de DAO: indexa a Classe ( Cliente, Endereço e  )
                                       //ao respectivo DAO
	private Map<String, List<IStrategy>> rns;//Map de Strategy: indexa a Classe ( Cliente, Endereço e  )
                                                 //as listas de RN
	public Fachada() {
            
		definirDAOS();
		definirRNS();

	}

	private void definirRNS() {//método para definir as regras de negócio de cada classe
		
                rns = new HashMap<String, List<IStrategy>>();//Map de Strategy: indexa a classe ( Disciplina, Cliente, 
                                                             //Professor, Endereço ou Curso ) às respectivas RN
		ValidadorDadosObrigatoriosCliente vCliente = new ValidadorDadosObrigatoriosCliente();//instância das regras de negócio
                //ValidadorExistenciaCliente vExCliente = new ValidadorExistenciaCliente();
                ValidadorDadosObrigatoriosEndereco vEndereco = new ValidadorDadosObrigatoriosEndereco();
                ValidadorDadosObrigatoriosCartao vCartao = new ValidadorDadosObrigatoriosCartao();
                ValidadorCpf vCpf = new ValidadorCpf();
		ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();

		List<IStrategy> rnsCliente = new ArrayList<IStrategy>();//instância da ArrayList que receberá as regras de negócio
		rnsCliente.add(vCliente);                                 //do objeto Cliente
		//rnsCliente.add(vExCliente);
                rnsCliente.add(vCpf);
		//rnsCliente.add(cDtCadastro);
                
                List<IStrategy> rnsEndereco = new ArrayList<IStrategy>();
                rnsEndereco.add(vEndereco);
                //rnsCliente.add(cDtCadastro);

                
                List<IStrategy> rnsCartao = new ArrayList<IStrategy>();
                rnsCartao.add(vCartao);
                //rnsCartao.add(cDtCadastro);
		
		rns.put(Cliente.class.getName(), rnsCliente);
                rns.put(Endereco.class.getName(), rnsEndereco);
                rns.put(Cartao.class.getName(), rnsCartao);
                
	}

	private void definirDAOS() {
            
		daos = new HashMap<String, IDAO>();
		daos.put(Cliente.class.getName(), new ClienteDAO());//retorna nome completo da classe ( br.com.fatecmc.eng3.domai....)
		daos.put(Endereco.class.getName(), new EnderecoDAO());//na key, e a instância do DAO para cada classe na value
		daos.put(Cartao.class.getName(), new CartaoDAO());
                
	}

	
	private String executarRegras(EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();//retorna nome completo da Classe de entidade
		StringBuilder msg = new StringBuilder();

		List<IStrategy> regras = rns.get(nmClasse);//atribui à lista regras as RN da Classe
                                                           //correspondente
		if (regras != null) {
			for (IStrategy s : regras) {//loop para processsar cada uma das RN
				String m = s.processar(entidade);

				if (m != null) {
					msg.append(m);//mensagens retornadas das RN
					msg.append("<br/>");
				}
			}
		}

		if (msg.length() > 0){
			return msg.toString();
                }else{
			return null;
                }
        }
        
        @Override
        public String salvar(EntidadeDominio entidade) {
                String nmClasse = entidade.getClass().getName();//retorna nome completo da Classe
                String msg = executarRegras(entidade);//executa RN da Classe correspondente
                if (msg == null) {//se todas as RN estiverem OK
                        IDAO dao = daos.get(nmClasse);//atribui a dao uma nova instância da Classe DAO correspondente
                        dao.salvar(entidade);//salva o objeto entidade
                } else {
                        return msg;//retorna mensagem de erro das RN
                }
                return null;
        }
        

	@Override
	public String excluir(EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();
		IDAO dao = daos.get(nmClasse);
		dao.excluir(entidade);
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade);
		if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			dao.alterar(entidade);
		} else {
			return msg;
		}
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
                String nmClasse = entidade.getClass().getName();
                List<EntidadeDominio> entidades = new ArrayList();
                IDAO dao = daos.get(nmClasse);                
                entidades = dao.consultar(entidade);
 		if (entidades!= null) {
			return entidades;
		}
		return null;
	}
}
