
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
import javax.servlet.RequestDispatcher;

public class VhSalvarCliente implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String txtNome = request.getParameter("txtNome");
        String txtGenero = request.getParameter("txtGenero");
        String txtDtNascimento = request.getParameter("txtDtNascimento");
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dtNascimento = LocalDate.parse(txtDtNascimento, dtf);
        String txtCpf = request.getParameter("txtCpf");
        String txtTelefone = request.getParameter("txtTelefone");
        String txtEmail = request.getParameter("txtEmail");
        String txtSenha = request.getParameter("txtSenha"); 
        
        ArrayList<Endereco> enderecos = new ArrayList<>();
        ArrayList<Cartao> cartoes = new ArrayList<>();
        
        Cliente cliente = new Cliente(txtNome, txtGenero, dtNascimento, txtCpf, txtTelefone, txtEmail, txtSenha, enderecos, cartoes);
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
                                out.println("<a class='blue' href='index.jsp'>Novo Cliente</a>");
			} else {
                                String nome = request.getParameter("txtNome");
                                String genero = request.getParameter("txtGenero");
                                String dtNascimento = request.getParameter("txtDtNascimento");
                                String cpf = request.getParameter("txtCpf");
                                String telefone = request.getParameter("txtTelefone");
                                String email = request.getParameter("txtEmail");
                                String senha = request.getParameter("txtSenha");
				
                                request.setAttribute("nome", nome);
                                request.setAttribute("genero", genero);
                                request.setAttribute("dtNascimento", dtNascimento);
                                request.setAttribute("cpf", cpf);
                                request.setAttribute("telefone", telefone);
                                request.setAttribute("email", email);
                                request.setAttribute("senha", senha);
                                
                                RequestDispatcher rd = request.getRequestDispatcher("/SalvarCliente.jsp");
                                rd.forward(request, response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
}

