<%-- 
    Document   : SalvarEndereco
    Created on : Sep 3, 2021, 7:41:10 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Endereço</title>
        <link rel="stylesheet" href="css/padrao.css?123456789" type="text/css">
        <script type="text/javascript" src="js/principal.js?123456789"></script>
    </head>
    <body>
        <%
        Object tpEndereco = request.getAttribute("tpEndereco");
        Object tpResidencia = request.getAttribute("tpResidencia");
        Object tpLogradouro = request.getAttribute("tpLogradouro");
        Object cep = request.getAttribute("cep");
        Object logradouro = request.getAttribute("logradouro");
        Object numero = request.getAttribute("numero");
        Object complemento = request.getAttribute("complemento");
        Object bairro = request.getAttribute("bairro");
        Object cidade = request.getAttribute("cidade");
        Object estado = request.getAttribute("estado");
        Object pais = request.getAttribute("pais");
        Object observacoes = request.getAttribute("observacoes");
        Object idcli = request.getAttribute("id_cli");
        Object nome = request.getAttribute("nome");
        %>
        
        <h1>Cadastro de Endereços</h1>
        
        <fieldset>
            <legend>Dados do Endereço Cadastrado</legend>
            
            <p>O seguinte endereço foi cadastrado com sucesso:</p>
            
            <p>
                ID do Cliente: <%=idcli%><br>
                Nome do Cliente: <%=nome%><br>
                Tipo de Endereço: <%=tpEndereco%><br>
                Tipo de Residência: <%=tpResidencia%><br>
                Tipo de Logradouro: <%=tpLogradouro%><br>
                CEP: <%=cep%><br>
                Logradouro: <%=logradouro%><br>
                Número: <%=numero%><br>
                Complemento: <%=complemento%><br>
                Bairro: <%=bairro%><br>
                Cidade: <%=cidade%><br>
                Estado: <%=estado%><br>
                País: <%=pais%><br>
                Observações: <%=observacoes%><br>
            </p>
        </fieldset> 
        <a class="blue"  href='index.jsp'>Início</a>
        <a class="blue" href="Controller?operacao=CONSULTAR&uri=ListarEndereco&txtIdCli=<%=idcli%>">Lista de Endereços</a>
    </body>
</html>
