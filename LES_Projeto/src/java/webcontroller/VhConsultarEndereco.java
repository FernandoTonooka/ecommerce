
package webcontroller;

import domain.Endereco;
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

public class VhConsultarEndereco implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        Endereco endereco = new Endereco();
        return endereco;
        
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
        response.setContentType("text/html");  
        PrintWriter out = null;  
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(VhConsultarEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("<link rel='stylesheet' href='css/padrao.css' type='text/css'>");
        out.println("<a class='blue' href='index.jsp'>INÍCIO</a>");  
        out.println("<h1 style='color: green; font-family: sans-serif'>Lista de Enderecos</h1>");  
          
        List<Endereco> enderecos = new ArrayList ((Collection) resultado);  
          
        out.print("<table border=1 width='100%'");  
        out.print("<tr><th>ID</th><th>Tipo de Endereço</th><th>Tipo de Residência</th><th>Tipo de Logradouro</th><th>CEP</th><th>Logradouro</th><th>Número</th><th>Complemento</th><th>Bairro</th><th>Cidade</th><th>Estado</th><th>País</th><th>Observações</th><th colspan=2>OPERAÇÃO</th></tr>");  
        for(Endereco e:enderecos){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getTpEndereco()+"</td><td>"+e.getTpResidencia()+"</td><td>"+e.getTpLogradouro()+"</td><td>"+e.getCep()+"</td><td>"+e.getLogradouro()+"</td><td>"+e.getNumero()+"</td><td>"+e.getComplemento()+"</td><td>"+e.getBairro()+"</td><td>"+e.getCidade().getDescricao()+"</td><td>"+e.getCidade().getEstado().getDescricao()+
                   "</td><td>"+e.getCidade().getEstado().getPais().getDescricao()+"</td><td>"+e.getObservacoes()+"</td><td><a href='AlterarEndereco.jsp?txtId="+e.getId()+"&txtTpEndereco="+e.getTpEndereco()+"&txtTpResidencia="+e.getTpResidencia()+"&txtTpLogradouro="+e.getTpLogradouro()+"&txtCep="+e.getCep()+"&txtLogradouro="+e.getLogradouro()+"&txtNumero="+e.getNumero()+
                   "&txtComplemento="+e.getComplemento()+"&txtBairro="+e.getBairro()+"&txtCidade="+e.getCidade().getDescricao()+"&txtEstado="+e.getCidade().getEstado().getDescricao()+"&txtPais="+e.getCidade().getEstado().getPais().getDescricao()+"&txtObservacoes="+e.getObservacoes()+"&txtIdCli="+e.getCliente().getId()+"'>ALTERAR</a></td><td><a href='Controller?operacao=EXCLUIR&uri=ExcluirEndereco&txtId="+e.getId()+"&txtIdCli="+e.getCliente().getId()+"'>EXCLUIR</a></td></tr>"); 
        }  
        out.print("</table>");  
          
        out.close();
    }
}