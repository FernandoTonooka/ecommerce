
package webcontroller;

import domain.Cartao;
import domain.Cliente;
import domain.EntidadeDominio;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VhSalvarCartao implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String txtBandeira = request.getParameter("txtBandeira");
        String txtNome = request.getParameter("txtNome");
        String txtNumero = request.getParameter("txtNumero");
        String txtValidade = request.getParameter("txtValidade");
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate validade = LocalDate.parse(txtValidade, dtf);
        String txtCvv = request.getParameter("txtCvv");
        
        int id = Integer.parseInt(request.getParameter("txtIdCli"));
        Cliente cliente = new Cliente(id);
        
        Cartao cartao = new Cartao(txtBandeira, txtNome, txtNumero, validade, txtCvv, cliente);
        return cartao;
        
    }
    
    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
        
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
                        String idcli = request.getParameter("txtIdCli");
                        
                        request.setAttribute("bandeira", bandeira);
                        request.setAttribute("nome", nome);
                        request.setAttribute("numero", numero);
                        request.setAttribute("validade", validade);
                        request.setAttribute("cvv", cvv);
                        request.setAttribute("idcli", idcli);

                        RequestDispatcher rd = request.getRequestDispatcher("/SalvarCartao.jsp");
                        rd.forward(request, response);
                }
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }	
    }
}
