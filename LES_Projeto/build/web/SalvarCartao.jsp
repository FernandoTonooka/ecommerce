<%-- 
    Document   : SalvarCartao
    Created on : Sep 9, 2021, 11:35:19 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cartões</title>
        <link rel="stylesheet" href="css/padrao.css?123456789" type="text/css">
        <script type="text/javascript" src="js/principal.js?123456789"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    </head>
    <body class="bg">
        <%
        Object bandeira = request.getAttribute("bandeira");
        Object nome = request.getAttribute("nome");
        Object numero = request.getAttribute("numero");
        Object validade = request.getAttribute("validade");
        Object cvv = request.getAttribute("cvv");
        Object idcli = request.getAttribute("txtIdCli");
        %>
        
        <h1>Cadastro de Cartões</h1>
        
        <fieldset>
            <legend>Dados do Cartão Cadastrado</legend>
            
            <p>O seguinte cartão foi cadastrado com sucesso:</p>
            
            <p>
                ID do Cliente: <%=idcli%><br>
                Bandeira: <%=bandeira%><br>
                Nome: <%=nome%><br>
                Número: <%=numero%><br>
                Validade: <%=validade%><br>
                CVV <%=cvv%><br>
            </p>
            
        </fieldset>
        <a class="blue" href='index.jsp'>Novo Cliente</a>
        <a class="blue" href="Controller?operacao=CONSULTAR&uri=ListarCartao&txtIdCli=<%=idcli%>">Lista de Cartões</a>
        
    </body>
</html>
