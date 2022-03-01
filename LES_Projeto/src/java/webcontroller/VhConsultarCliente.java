
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

public class VhConsultarCliente implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        Cliente cliente = new Cliente();
        return cliente;
    }
    
    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
        response.setContentType("text/html");  
        PrintWriter out = null;  
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(VhConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("<link rel='stylesheet' href='css/padrao.css' type='text/css'>");
        out.println("<a class='blue' href='index.jsp'>INÍCIO</a>");  
        out.println("<h1 style='color: green; font-family: sans-serif'>Lista de Clientes</h1>");  
          
        List<Cliente> clientes = new ArrayList<>((Collection) resultado); 
        
        out.print("<table border=1 width='100%'");  
        out.print("<tr><th>ID</th><th>Nome</th><th>CPF</th><th>Telefone</th><th>E-mail</th><th colspan=2>OPERAÇÃO</th><th colspan=2>CADASTRAR</th></tr>");  
        for(Cliente c:clientes){  
         out.print("<tr><td>"+c.getId()+"</td><td>"+c.getNome()+"</td><td>"+c.getCpf()+"</td><td>"+c.getTelefone()+"</td><td>"+c.getEmail()+
                   "</td><td><a href='AlterarCliente.jsp?txtId="+c.getId()+"&txtNome="+c.getNome()+"&txtDtNascimento="+c.getDtNascimento()+"&txtCpf="+c.getCpf()+"&txtTelefone="+c.getTelefone()+
                   "&txtEmail="+c.getEmail()+"&txtSenha="+c.getSenha()+"'>ALTERAR</a></td><td><a href='Controller?operacao=EXCLUIR&uri=ExcluirCliente&txtId="+c.getId()+
                 "'>EXCLUIR</a><td><a href='Endereco.jsp?txtIdCli="+c.getId()+"&txtNome="+c.getNome()+"&txtCpf="+c.getCpf()+"'>ENDEREÇO</a></td><td><a href='Cartao.jsp?txtIdCli="+c.getId()+
                 "&txtNome="+c.getNome()+"&txtCpf="+c.getCpf()+"'>CARTÃO</a></td></tr>"); 
        }  
        out.print("</table>");  
          
        out.close();
    }
}
