/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcontroller;

import domain.Cartao;
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

/**
 *
 * @author fernandotonooka
 */
public class VhConsultarCartao implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        Cartao cartao = new Cartao();
        return cartao;
    }
    
    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
        response.setContentType("text/html");  
        PrintWriter out = null;  
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(VhConsultarCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("<link rel='stylesheet' href='css/padrao.css' type='text/css'>");
        out.println("<a class='blue' href='index.jsp'>INÍCIO</a>");  
        out.println("<h1 style='color: green; font-family: sans-serif'>Lista de Cartões</h1>");  
          
        List<Cartao> cartoes = new ArrayList ((Collection) resultado);  
          
        out.print("<table border=1 width='100%'");  
        out.print("<tr><th>ID</th><th>Bandeira</th><th>Nome</th><th>Número</th><th>Validade</th><th>CVV</th><th colspan=2>OPERAÇÃO</th></tr>");  
        for(Cartao c:cartoes){  
         out.print("<tr><td>"+c.getId()+"</td><td>"+c.getBandeira()+"</td><td>"+c.getNome()+"</td><td>"+c.getNumero()+"</td><td>"+c.getValidade()+"</td><td>"+c.getCvv()+
                   "</td><td><a href='AlterarCartao.jsp?txtId="+c.getId()+"&txtBandeira="+c.getBandeira()+"&txtNome="+c.getNome()+"&txtNumero="+c.getNumero()+"&txtValidade="+c.getValidade()+
                   "&txtCvv="+c.getCvv()+"&txtIdCli="+c.getCliente().getId()+"'>ALTERAR</a></td><td><a href='Controller?operacao=EXCLUIR&uri=ExcluirCartao&txtId="+c.getId()+"&txtIdCli="+c.getCliente().getId()+"'>EXCLUIR</a></td></tr>"); 
        }  
        out.print("</table>");  
          
        out.close();
    }
}
