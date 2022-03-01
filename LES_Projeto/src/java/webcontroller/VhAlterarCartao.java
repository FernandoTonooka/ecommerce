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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernandotonooka
 */
public class VhAlterarCartao implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request){
        
        String txtId = request.getParameter("txtId");
        int id = Integer.parseInt(txtId);
        String txtBandeira = request.getParameter("txtBandeira");
        String txtNome = request.getParameter("txtNome");
        String txtNumero = request.getParameter("txtNumero");
        String txtValidade = request.getParameter("txtValidade");
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate validade = LocalDate.parse(txtValidade, dtf);
        String txtCvv = request.getParameter("txtCvv");
        
        int idcli = Integer.parseInt(request.getParameter("txtIdCli"));
        Cliente cliente = new Cliente(idcli);
        
        Cartao cartao = new Cartao(id, txtBandeira, txtNome, txtNumero, validade, txtCvv, cliente);
        return cartao;
        
    }
    
    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
        response.setContentType("text/html");
        response.setContentType("text/html");
        PrintWriter out;
        try {
                out = response.getWriter();
                if (resultado != null) {
                        out.println("<h2>"+resultado+"</h2>");
                        out.println("<a class='blue' href='index.jsp'>Novo Cliente</a>");
                } else {
                        String bandeira = request.getParameter("txtBandeira");
                        String nome = request.getParameter("txtNome");
                        String numero = request.getParameter("txtNumero");
                        String txtValidade = request.getParameter("txtValidade");
                        DateTimeFormatter dtf;
                        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate validade = LocalDate.parse(txtValidade, dtf);
                        String cvv = request.getParameter("txtCvv");
                        
                        int idcli = Integer.parseInt(request.getParameter("txtIdCli"));
                        //Cliente cliente = new Cliente(idcli);

                        out.println("<h1>Cadastro de Cartões</h1>"); 

                        out.println("<fieldset>"); 
                        out.println("<legend>Dados do Cartão Editado</legend>"); 

                        out.println("<p>O seguinte cartão foi editado com sucesso:</p>"); 

                        out.println("<p>"); 
                        out.println("ID: " +idcli+ "<br>");
                        out.println("Bandeira: " +bandeira+ "<br>"); 
                        out.println("Nome: " +nome+ "<br>");
                        out.println("Número: " +numero+ "<br>"); 
                        out.println("Validade: " +validade+ "<br>"); 
                        out.println("CVV: " +cvv+ "<br>"); 
                        out.println("</p>"); 
                        out.println("</fieldset>"); 
                        out.println("</body>"); 
                        out.println("</html>");
                        out.println("<a href='index.jsp'>Início</a>\n");
                        out.println("<a href='Controller?operacao=CONSULTAR&uri=ListarCartao&txtIdCli="+idcli+"'>Lista de Cartões</a>");
                }
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }	
    }   
}
