/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcontroller;

import domain.Cidade;
import domain.Cliente;
import domain.Endereco;
import domain.EntidadeDominio;
import domain.Estado;
import domain.Pais;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernandotonooka
 */
public class VhSalvarEndereco implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
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
        
        int id_cli = Integer.parseInt(request.getParameter("txtIdCli"));
        Cliente cliente = new Cliente(id_cli);
        
        Pais pais = new Pais(txtPais);
        
        Estado estado = new Estado(txtEstado, pais);
        
        Cidade cidade = new Cidade(txtCidade, estado);
        
        Endereco endereco = new Endereco(txtTpEndereco, txtTpResidencia, txtTpLogradouro, txtCep, txtLogradouro, txtNumero, txtComplemento, txtBairro, cidade, estado, pais, txtObservacoes, cliente);
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
                                out.println("<a href='index.jsp'>Início</a>");
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
                                String id_cli = request.getParameter("txtIdCli");
                                String nome = request.getParameter("txtNome");
				
                                request.setAttribute("tpEndereco", tpEndereco);
                                request.setAttribute("tpResidencia", tpResidencia);
                                request.setAttribute("tpLogradouro", tpLogradouro);
                                request.setAttribute("cep", cep);
                                request.setAttribute("logradouro", logradouro);
                                request.setAttribute("numero", numero);
                                request.setAttribute("complemento", complemento);
                                request.setAttribute("bairro", bairro);
                                request.setAttribute("cidade", cidade);
                                request.setAttribute("estado", estado);
                                request.setAttribute("pais", pais);
                                request.setAttribute("observacoes", observacoes);
                                request.setAttribute("id_cli", id_cli);
                                request.setAttribute("nome", nome);
                                
                                RequestDispatcher rd = request.getRequestDispatcher("/SalvarEndereco.jsp");
                                rd.forward(request, response);    
                        }
                    }catch (IOException ex) {
                        Logger.getLogger(VhSalvarEndereco.class.getName()).log(Level.SEVERE, null, ex);
                    } 
    }
}