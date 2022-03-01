<%-- 
    Document   : Cartao
    Created on : Sep 9, 2021, 11:34:46 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
        <title>Cadastro de Cartões</title>
        <link rel="stylesheet" href="css/padrao.css" type="text/css">
        <script type="text/javascript" src="js/principal.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <script src="view-source:https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="bg">
        
    <%
    request.setCharacterEncoding("UTF-8");
    String txtIdCli = request.getParameter("txtIdCli");
    int id = Integer.parseInt(txtIdCli);    
    String nome = request.getParameter("txtNome");
    String cpf = request.getParameter("txtCpf");
    %>    
        
    <h1>Novo Cartão - Cliente: <%=nome%>  CPF: <%=cpf%></h1>  
    <form action="Controller?txtIdCli=<%=id%>&txtNome=<%=nome%>" method="post">  
        <fieldset style="width: 50%; position: relative"> 
            <legend>Dados do Cartão</legend>
            <p><label for="bandeira">Bandeira </label><select name="txtBandeira">
                    <option id="americanexpress" name="txtBandeira" value="americanexpress">American Express</option>
                    <option id="dinersclub" name="txtBandeira" value="dinersclub">Diners Club</option>
                    <option id="elo" name="txtBandeira" value="elo">Elo</option>
                    <option id="hipercard" name="txtBandeira" value="hipercard">Hipercard</option>
                    <option id="mastercard" name="txtBandeira" value="mastercard">Mastercard</option>
                    <option id="visa" name="txtBandeira" value="visa">Visa</option>
                    <option id="outra" name="txtBandeira" value="outra">Outra</option>
            </select> 
            <p><label for="nome">Nome </label><input type="text" id="txtNome" name="txtNome" size="40"/></p>  
            <p><label for="numero">Número </label><input type="text" id="txtNumero" name="txtNumero" size="16"/></p>
            <p><label for="validade">Validade </label><input type="date" id="txtValidade" name="txtValidade" /></p>  
            <p><label for="cvv">CVV </label><input type="text" id="txtCvv" name="txtCvv" /></p>  
            
            <input class="green" type="submit" id="operacao" name="operacao" value="SALVAR"/>
            <input type="hidden" id="uri" name="uri" value="SalvarCartao"/>
            
        </fieldset>
    </form>  
    <br/>  
    
    <a class="blue" href="Controller?operacao=CONSULTAR&uri=ConsultarCliente">Lista de Clientes</a>
    <a class="blue" href="Controller?operacao=CONSULTAR&uri=ListarEndereco&txtIdCli=<%=id%>">Lista de Endereços</a>
    <a class="blue" href="Controller?operacao=CONSULTAR&uri=ListarCartao&txtIdCli=<%=id%>">Lista de Cartões</a>

    </body>
</html>
