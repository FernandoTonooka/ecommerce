
package webcontroller;

import domain.Cliente;
import domain.EntidadeDominio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VhEntrarCliente implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String txtCpf = request.getParameter("txtCpf");
        String txtSenha = request.getParameter("txtSenha");
        
        Cliente cliente = new Cliente(txtCpf, txtSenha);
        return cliente;
    }
    
    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
        response.setContentType("text/html");  
        PrintWriter out = null;  
        try {
            out = response.getWriter();
            if(resultado == null || resultado == ""){
                out.println("Cliente não cadastrado!");
            }else{
                
                out.println("<link rel='stylesheet' href='css/padrao.css' type='text/css'>");
                out.println("<a class='blue' href='index.jsp'>INÍCIO</a>");
                out.println("<h1 style='color: green; font-family: sans-serif'>Lista de Clientes</h1>");
                
                List<Cliente> clientes = new ArrayList<>((Collection) resultado);
                
                out.print("<table border=1 width='100%'");
                out.print("<tr><th>ID</th><th>Nome</th><th>Gênero</th><th>Data de Nascimento</th><th>CPF</th><th>Telefone</th><th>E-mail</th><th>Senha</th><th colspan=2>OPERAÇÃO</th></tr>");
                for(Cliente c:clientes){
                    out.print("<tr><td>"+c.getId()+"</td><td>"+c.getNome()+"</td><td>"+c.getGenero()+"</td><td>"+c.getDtNascimento()+"</td><td>"+c.getCpf()+"</td><td>"+c.getTelefone()+"</td><td>"+c.getEmail()+"</td><td>"+c.getSenha()+
                            "</td><td><a href='AlterarCliente.jsp?txtId="+c.getId()+"&txtNome="+c.getNome()+"&txtDtNascimento="+c.getDtNascimento()+"&txtCpf="+c.getCpf()+"&txtTelefone="+c.getTelefone()+
                            "&txtEmail="+c.getEmail()+"&txtSenha="+c.getSenha()+"'>ALTERAR</a></td><td><a href='Controller?operacao=EXCLUIR&uri=ExcluirCliente&txtId="+c.getId()+"'>EXCLUIR</a></td></tr>");
                }
                out.print("</table>");
                
                out.close();
            }
        }catch (IOException ex) {
            Logger.getLogger(VhConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

