
package webcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EntidadeDominio;
import domain.Cliente;
import domain.Cidade;
import domain.Endereco;
import domain.Estado;
import util.DataConvert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

public class VhExcluirCliente implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request){
        
        String txtId = request.getParameter("txtId");
        int id = Integer.parseInt(txtId);
        
        Cliente cliente = new Cliente(id);
        
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
            Logger.getLogger(VhExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
			if (resultado == null) {
				out.println("<h1 style='color: green'>Cliente Excluído com Sucesso!</h1>");
                                out.println("<a href='index.jsp'>Início</a>");
                                out.println("<a href='Controller?operacao=CONSULTAR&uri=ConsultarCliente'>Lista de Clientes</a>");
                        }
    }
}
