    
package webcontroller;

import domain.Cidade;
import domain.Cliente;
import domain.Endereco;
import domain.EntidadeDominio;
import domain.Estado;
import domain.Pais;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VhAlterarEndereco implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request){
        
        String txtId = request.getParameter("txtId");
        int id = Integer.parseInt(txtId);
        String txtTpEndereco = request.getParameter("txtTpEndereco");
        String txtTpResidencia = request.getParameter("txtTpResidencia");
        String txtTpLogradouro = request.getParameter("txtTpLogradouro");
        String txtCep = request.getParameter("txtCep");
        String txtLogradouro = request.getParameter("txtLogradouro");
        String txtNumero = request.getParameter("txtNumero");
        String txtComplemento = request.getParameter("txtComplemento");
        String txtBairro = request.getParameter("txtBairro");
        String txtCidade = request.getParameter("txtCidade");
        String txtEstado = request.getParameter("txtEstado");
        String txtPais = request.getParameter("txtPais");
        String txtObservacoes = request.getParameter("txtObservacoes");
        
        int txtIdCli = Integer.parseInt(request.getParameter("txtIdCli"));
        
        Pais pais = new Pais(txtPais);
        
        Estado estado = new Estado(txtEstado, pais);
        
        Cidade cidade = new Cidade(txtCidade, estado);
        
        Cliente cliente = new Cliente(txtIdCli);
        
        Endereco endereco = new Endereco(id, txtTpEndereco, txtTpResidencia, txtTpLogradouro, txtCep, txtLogradouro, txtNumero, txtComplemento, txtBairro, cidade, estado, pais, txtObservacoes, cliente);
        return endereco;
        
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
                                out.println("<a class='blue' href='Endereco.jsp'>Voltar</a>");
			} else {
                                String tpEndereco = request.getParameter("txtTpEndereco");
                                String tpResidencia = request.getParameter("txtTpResidencia");
                                String tpLogradouro = request.getParameter("txtTpLogradouro");
                                String cep = request.getParameter("txtCep");
                                String logradouro = request.getParameter("txtLogradouro");
                                String numero = request.getParameter("txtNumero");
                                String complemento = request.getParameter("txtComplemento");
                                String bairro = request.getParameter("txtBairro");
                                String cidade = request.getParameter("txtCidade");
                                String estado = request.getParameter("txtEstado");
                                String pais = request.getParameter("txtPais");
                                String observacoes = request.getParameter("txtObservacoes");
                                String idcli = request.getParameter("txtIdCli");
                                
                                out.println("<h1>Cadastro de Endereços</h1>"); 
        
                                out.println("<fieldset>"); 
                                out.println("<legend>Dados do Endereço Editado</legend>"); 
            
                                out.println("<p>O seguinte endereço foi editado com sucesso:</p>"); 
            
                                out.println("<p>"); 
                                out.println("Tipo de Endereço: " +tpEndereco+ "<br>"); 
                                out.println("Tipo de Residência: " +tpResidencia+ "<br>");
                                out.println("Tipo de Logradouro: " +tpLogradouro+ "<br>"); 
                                out.println("CEP: " +cep+ "<br>"); 
                                out.println("Logradouro: " +logradouro+ "<br>"); 
                                out.println("Número: " +numero+ "<br>"); 
                                out.println("Complemento:" +complemento+ "<br>");
                                out.println("Bairro:" +bairro+ "<br>");
                                out.println("Cidade:" +cidade+ "<br>");
                                out.println("Estado:" +estado+ "<br>");
                                out.println("País:" +pais+ "<br>");
                                out.println("Observações:" +observacoes+ "<br>");
                                out.println("</p>"); 
                                out.println("</fieldset>"); 
                                out.println("</body>"); 
                                out.println("</html>");
                                out.println("<a class='blue' href='Endereco.jsp'>Voltar</a>\n");
                                out.println("<a href='Controller?operacao=CONSULTAR&uri=ListarEndereco&txtIdCli="+idcli+"'>Lista de Endereços</a>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
    
}
