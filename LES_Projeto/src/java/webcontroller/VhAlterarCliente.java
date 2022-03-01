
package webcontroller;

import domain.Cartao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EntidadeDominio;
import domain.Cliente;
import domain.Endereco;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VhAlterarCliente implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request){
        
        String txtId = request.getParameter("txtId");
        int id = Integer.parseInt(txtId);
        String txtNome = request.getParameter("txtNome");
        String txtGenero = request.getParameter("txtGenero");
        String txtDtNascimento = request.getParameter("txtDtNascimento");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dtNascimento = LocalDate.parse(txtDtNascimento, dtf);
        String txtCpf = request.getParameter("txtCpf");
        String txtTelefone = request.getParameter("txtTelefone");
        String txtEmail = request.getParameter("txtEmail");
        String txtSenha = request.getParameter("txtSenha");
        
        ArrayList<Endereco> enderecos = new ArrayList<>();
        ArrayList<Cartao> cartoes = new ArrayList<>();
        
        Cliente cliente = new Cliente(id, txtNome, txtGenero, dtNascimento, txtCpf, txtTelefone, txtEmail, txtSenha, enderecos, cartoes);
        return cliente;
        
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
                                out.println("<a href='index.jsp'>Início</a>");
			} else {
                                String nome = request.getParameter("txtNome");
                                String genero = request.getParameter("txtGenero");
                                String txtDtNascimento = request.getParameter("txtDtNascimento");
                                DateTimeFormatter dtf;
                                dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate dtNascimento = LocalDate.parse(txtDtNascimento, dtf);
                                String cpf = request.getParameter("txtCpf");
                                String telefone = request.getParameter("txtTelefone");
                                String email = request.getParameter("txtEmail");
                                String senha = request.getParameter("txtSenha");
                                
                                out.println("<h1>Cadastro de Clientes</h1>"); 
        
                                out.println("<fieldset>"); 
                                out.println("<legend>Dados do Cliente Editado</legend>"); 
            
                                out.println("<p>O seguinte cliente foi editado com sucesso:</p>"); 
            
                                out.println("<p>"); 
                                out.println("Nome: " +nome+ "<br>"); 
                                out.println("Gênero: " +genero+ "<br>");
                                out.println("Data de Nascimento: " +dtNascimento+ "<br>"); 
                                out.println("CPF: " +cpf+ "<br>"); 
                                out.println("Telefone: " +telefone+ "<br>"); 
                                out.println("E-mail: " +email+ "<br>"); 
                                out.println("Senha:" +senha+ "<br>"); 
                                out.println("</p>"); 
                                out.println("</fieldset>"); 
                                out.println("</body>"); 
                                out.println("</html>");
                                out.println("<a href='index.jsp'>Início</a>\n");
                                out.println("<a href='Controller?operacao=CONSULTAR&uri=ConsultarCliente'>Lista de Clientes</a>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

