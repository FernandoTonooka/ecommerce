<%-- 
    Document   : TesteCartao
    Created on : Sep 18, 2021, 7:06:33 PM
    Author     : fernandotonooka
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TesteCartao</title>
    </head>
    <body>
        <%
        //request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("txtId");
        String bandeira = request.getParameter("txtBandeira");
        String nome = request.getParameter("txtNome");
        String numero = request.getParameter("txtNumero");
        String validade = request.getParameter("txtValidade");
        String cvv = request.getParameter("txtCvv");
        String idcli = request.getParameter("txtIdCli");
        String operacao = request.getParameter("operacao");
        String uri = request.getParameter("uri");
        %>
        
        <h1>Cadastro de Cartões</h1> 

            <fieldset> 
            <legend>Dados do Cartão Editado</legend>

            <p>O seguinte cartão foi editado com sucesso:</p> 

            <p> 
            ID do Cliente: <%=idcli%><br>    
            ID: <%=id%><br>    
            Bandeira: <%=bandeira%><br> 
            Nome: <%=nome%><br>
            Número: <%=numero%><br> 
            Validade: <%=validade%><br>
            CVV: <%=cvv%><br>
            ID Cliente: <%=idcli%><br>
            Operação: <%=operacao%><br>
            URI: <%=uri%><br>
            </p> 
            </fieldset>
    </body>
</html>
