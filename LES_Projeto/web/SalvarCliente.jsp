<%-- 
    Document   : SalvarCliente
    Created on : Aug 20, 2021, 11:23:14 PM
    Author     : fernandotonooka
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
        <link rel="stylesheet" href="css/padrao.css?123456789" type="text/css">
        <script type="text/javascript" src="js/principal.js?123456789"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    </head>
    <body class="bg">
        <%
        Object nome = request.getAttribute("nome");
        Object dtNascimento = request.getAttribute("dtNascimento");
        Object cpf = request.getAttribute("cpf");
        Object telefone = request.getAttribute("telefone");
        Object email = request.getAttribute("email");
        Object senha = request.getAttribute("senha");
        %>
        <h1>Cadastro de Clientes</h1>
        
        <fieldset>
            <legend>Dados do Cliente Cadastrado</legend>
            
            <p>O seguinte cliente foi cadastrado com sucesso:</p>
            
            <p>
                Nome: <%=nome%><br>
                Data de Nascimento: <%=dtNascimento%><br>
                CPF: <%=cpf%><br>
                Telefone: <%=telefone%><br>
                E-mail: <%=email%><br>
                Senha: <%=senha%><br>
            </p>
            
            <a class="blue" href="Controller?operacao=CONSULTAR&uri=ConsultarCliente">Cadastrar Endereço</a>
            <a class="blue" href="Controller?operacao=CONSULTAR&uri=ConsultarCliente">Cadastrar Cartão</a>
        
        </fieldset>
        <a class="blue" href='index.jsp'>Início</a>
        <a class="blue" href="Controller?operacao=CONSULTAR&uri=ConsultarCliente">Lista de Clientes</a>
        
    </body>
</html>
