<%-- 
    Document   : AlterarCartao
    Created on : Sep 9, 2021, 11:34:59 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Cadastro de Cartão</title>
        <link rel="stylesheet" href="css/padrao.css?123456789" type="text/css">
        <script type="text/javascript" src="js/principal.js?123456789"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <script src="view-source:https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <%
        String txtCpf = request.getParameter("txtCpf");
        String txtId = request.getParameter("txtId");
        String txtBandeira = request.getParameter("txtBandeira");
        String txtNome = request.getParameter("txtNome");
        String txtNumero = request.getParameter("txtNumero");
        String txtValidade = request.getParameter("txtValidade");
        String txtCvv = request.getParameter("txtCvv");
        String txtIdCli = request.getParameter("txtIdCli");
        %>
        
    <h1>Editar Cartão</h1>  
    <form action="Controller?idcli=<%=txtIdCli%>" method="post">  
        <fieldset style="width: 50%; position: relative"> 
            <legend>Dados do Cartão</legend>
            <p><label for="id">ID </label><input type="text" id="txtId" name="txtId" size="3" value="<%=txtId%>" readonly="readonly"/></p>
            <p><label for="idcli">ID do Cliente</label><input type="text" id="txtIdCli" name="txtIdCli" size="3" value="<%=txtIdCli%>" readonly="readonly"/></p>
            <p><label for="bandeira">Bandeira </label><select name="txtBandeira">
                    <option id="americanexpress" name="txtBandeira" value="americanexpress">American Express</option>
                    <option id="dinersclub" name="txtBandeira" value="dinersclub">Diners Club</option>
                    <option id="elo" name="txtBandeira" value="elo">Elo</option>
                    <option id="hipercard" name="txtBandeira" value="hipercard">Hipercard</option>
                    <option id="mastercard" name="txtBandeira" value="mastercard">Mastercard</option>
                    <option id="visa" name="txtBandeira" value="visa">Visa</option>
                    <option id="outra" name="txtBandeira" value="outra">Outra</option>
            </select> 
            <p><label for="nome">Nome </label><input type="text" id="txtNome" name="txtNome" size="40" value="<%=txtNome%>" /></p>  
            <p><label for="numero">Número </label><input type="text" id="txtNumero" name="txtNumero" size="16" value="<%=txtNumero%>"/></p>
            <p><label for="validade">Validade </label><input type="date" id="txtValidade" name="txtValidade" value="<%=txtValidade%>"/></p>  
            <p><label for="cvv">CVV </label><input type="text" id="txtCvv" name="txtCvv" value="<%=txtCvv%>"/></p>  
            
            <input class="green" type="submit" id="operacao" name="operacao" value="ALTERAR"/>
            <input type="hidden" id="uri" name="uri" value="AlterarCartao"/>
            
        </fieldset>
    </form>  
    <br/>  
        
    </body>
</html>
