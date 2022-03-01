<%-- 
    Document   : TesteEndereco
    Created on : Sep 2, 2021, 10:26:17 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Endereço</title>
    </head>
    <body>
        <%
        request.setCharacterEncoding("UTF-8");
        String idcli = request.getParameter("txtIdCli");
        int txtId = Integer.parseInt(request.getParameter("txtId"));
        String txtNome = request.getParameter("txtNome");    
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
        String txtOperacao = request.getParameter("operacao");
        String txtUri = request.getParameter("uri");
        %>
        
        <h1>Teste de Cadastro de Endereços</h1>
        
        <fieldset>
            <legend>Dados do Endereço Gerado</legend>
            
            <p>O seguinte endereço foi gerado com sucesso:</p>
            
            <p>
                ID do Cliente: <%=idcli%><br>
                ID: <%=txtId%><br>
                Nome: <%=txtNome%><br>
                Tipo de Endereço: <%=txtTpEndereco%><br>
                Tipo de Residência: <%=txtTpResidencia%><br>
                Tipo de Logradouro: <%=txtTpLogradouro%><br>
                CEP: <%=txtCep%><br>
                Logradouro: <%=txtLogradouro%><br>
                Número: <%=txtNumero%><br>
                Complemento: <%=txtComplemento%><br>
                Bairro: <%=txtBairro%><br>
                Cidade: <%=txtCidade%><br>
                Estado: <%=txtEstado%><br>
                País: <%=txtPais%><br>
                Observações: <%=txtObservacoes%><br>
                Operação: <%=txtOperacao%><br>
                URI: <%=txtUri%><br>
            </p>
        </fieldset> 
    </body>
</html>
