
package webcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.EntidadeDominio;
import controller.AlterarCommand;
import controller.ConsultarCommand;
import controller.ExcluirCommand;
import controller.ICommand;
import controller.SalvarCommand;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.FilterChain;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;//primeira versão da classe. 1L deve ser alterado para 2L
    private static String operacao = null;          //e assim por diante se houver uma alteração na classe
    private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> vhs;
    
    public Controller() {//construtor cria Map para Command e ViewHelper
        super();
        commands = new HashMap<String, ICommand>();//Map para Command: indexa as operações dos Forms HTML às Commands
        commands.put("SALVAR", new SalvarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());	
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("ALTERAR", new AlterarCommand());
        /*
         * Utilizando o ViewHelper para tratar especificações de qualquer tela e
         * indexando cada ViewHelper pela url em que esta servlet é chamada no form
         * garantimos que esta servlet atenderá qualquer entidade
         */

        vhs = new HashMap<String, IViewHelper>();
        /*
         * A chave do mapa é o mapeamento da servlet para cada form que está configurado
         * no web.xml e sendo utilizada no action do html
         */
        vhs.put("EntrarCliente", new VhEntrarCliente());
        vhs.put("SalvarCliente", new VhSalvarCliente());
        vhs.put("ConsultarCliente", new VhConsultarCliente());
        vhs.put("ExcluirCliente", new VhExcluirCliente());
        vhs.put("AlterarCliente", new VhAlterarCliente());
        vhs.put("SalvarEndereco", new VhSalvarEndereco());
        vhs.put("ConsultarEndereco", new VhConsultarEndereco());
        vhs.put("ExcluirEndereco", new VhExcluirEndereco());
        vhs.put("AlterarEndereco", new VhAlterarEndereco());
        vhs.put("ListarEndereco", new VhListarEndereco());
        vhs.put("SalvarCartao", new VhSalvarCartao());
        vhs.put("ConsultarCartao", new VhConsultarCartao());
        vhs.put("ExcluirCartao", new VhExcluirCartao());
        vhs.put("AlterarCartao", new VhAlterarCartao());
        vhs.put("ListarCartao", new VhListarCartao());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                operacao = request.getParameter("operacao");
                
                String uri = request.getParameter("uri");
                
                IViewHelper vh = vhs.get(uri);
                EntidadeDominio entidade = vh.getEntidade(request);
                
                ICommand cmd = commands.get(operacao);
                
                Object msg = cmd.execute(entidade);
                
                vh.setView(msg, request, response);
                                
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                request.setCharacterEncoding("UTF-8");
                processRequest(request, response);
                
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
                request.setCharacterEncoding("UTF-8");
            	processRequest(request, response);
                
    }
}
