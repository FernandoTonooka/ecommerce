
package webcontroller;

import domain.Cliente;
import domain.Endereco;
import domain.EntidadeDominio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VhExcluirEndereco implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request){
        
        String txtId = request.getParameter("txtId");
        int id = Integer.parseInt(txtId);
        String txtIdCli = request.getParameter("txtIdCli");
        int idcli = Integer.parseInt(txtIdCli);
        
        Cliente cliente = new Cliente(idcli);
        
        Endereco endereco = new Endereco(id, cliente);
        
        return endereco;
    }
    
    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
        
        String id = request.getParameter("txtId");
        String idcli = request.getParameter("txtIdCli");
        
        response.setContentType("text/html");
        PrintWriter out = null;
		
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(VhExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
			if (resultado == null) {
				out.println("<h1 style='color: green'>Endereço Excluído com Sucesso!</h1>");
                                out.println("<a href='index.jsp'>Início</a>");
                                out.println("<a href='Controller?operacao=CONSULTAR&uri=ListarEndereco&txtIdCli="+idcli+"&txtId="+id+"'>Lista de Endereços</a>");
                        }
    }
}
    

