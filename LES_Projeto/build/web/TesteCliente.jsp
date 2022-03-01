<%-- 
    Document   : Teste
    Created on : Aug 26, 2021, 9:09:46 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Cliente</title>
    </head>
    <body>
        <%
        String txtId = request.getParameter("txtId");
        String txtNome = request.getParameter("txtNome");
        String txtGenero = request.getParameter("txtGenero");
        String txtDtNascimento = request.getParameter("txtDtNascimento");
        String txtCpf = request.getParameter("txtCpf");
        String txtTelefone = request.getParameter("txtTelefone");
        String txtEmail = request.getParameter("txtEmail");
        String txtSenha = request.getParameter("txtSenha");
        String txtOperacao = request.getParameter("operacao");
        String txtUri = request.getParameter("uri");
         %>
         
        <h1>Teste de Cadastro de Clientes</h1>
        
        <fieldset>
            <legend>Dados do Cliente Gerado</legend>
            
            <p>O seguinte cliente foi gerado com sucesso:</p>
            
            <p>
                ID: <%=txtId%><br>
                Nome: <%=txtNome%><br>
                Gênero: <%=txtGenero%><br>
                Data de Nascimento: <%=txtDtNascimento%><br>
                CPF: <%=txtCpf%><br>
                Telefone: <%=txtTelefone%><br>
                E-mail: <%=txtEmail%><br>
                Senha: <%=txtSenha%><br>
                Operação: <%=txtOperacao%><br>
                URI: <%=txtUri%><br>
            </p>
        </fieldset> 
    </body>
</html>
