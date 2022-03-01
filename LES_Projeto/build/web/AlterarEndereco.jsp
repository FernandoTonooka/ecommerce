<%-- 
    Document   : AlterarEndereco
    Created on : Sep 3, 2021, 9:25:23 PM
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <script src="view-source:https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="bg" >
            
    <script>
        $(documento).ready(function(){
            $("#txtCep").inputmask("99999-999");
        });
    </script>
     
    <%
    String txtId = request.getParameter("txtId");
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
    String txtIdCli = request.getParameter("txtIdCli");
    %>
    
    <h1>Editar Endereço</h1>
    <form action="Controller" method="post">  
        <fieldset style="width: 50%; position: relative"> 
            <legend>Dados do Endereço</legend>
            <p><label for="id">ID </label><input type="text" id="txtId" name="txtId" size="3" value="<%=txtId%>" readonly="readonly"/></p>
            <p><label for="idcli">ID do Cliente</label><input type="text" id="txtIdCli" name="txtIdCli" size="3" value="<%=txtIdCli%>" readonly="readonly"/></p>
            <p><label for="tpresidencia">Tipo de Endereço </label>
            <input type="radio" id="residencia" name="txtTpEndereco" value="residencia"><label for="txtTpEndereco">Residência</label>
            <input type="radio" id="cobranca" name="txtTpEndereco" value="cobranca"><label for="txtTpEndereco">Cobrança</label>
            <input type="radio" id="entrega" name="txtTpEndereco" value="entrega"><label for="txtTpEndereco">Entrega</label>
            <p><label for="tpresidencia">Tipo de Residência </label><select name="txtTpResidencia">
                    <option id="apartamento" name="txtTpResidencia" value="apartamento">Apartamento</option>
                    <option id="casa" name="txtTpResidencia" value="casa">Casa</option>
                    <option id="galpao" name="txtTpResidencia" value="galpao">Galpão</option>
            </select>
            <p><label for="tplogradouro">Tipo de Logradouro </label><select name="txtTpLogradouro">
                    <option id="alameda" name="txtTpLogradouro" value="alameda">Alameda</option>
                    <option id="avenida" name="txtTpLogradouro" value="avenida">Avenida</option>
                    <option id="estrada" name="txtTpLogradouro" value="estrada">Estrada</option>
                    <option id="rodovia" name="txtTpLogradouro" value="rodovia">Rodovia</option>
                    <option id="rua" name="txtTpLogradouro" value="rua">Rua</option>
                    <option id="travessa" name="txtTpLogradouro" value="travessa">Travessa</option>
            </select>        
            <p><label for="cep">CEP </label><input type="text" id="txtCep" name="txtCep" value="<%=txtCep%>"  size="10"/><input type="button" onclick="javascript: pesquisacep(txtCep.value)" value="Pesquisar CEP"></p>
            <p><label for="logradouro">Logradouro </label><input type="text" id="txtLogradouro" name="txtLogradouro" value="<%=txtLogradouro%>"  size="50"/></p>  
            <p><label for="numero">Número </label><input type="text" id="txtNumero" name="txtNumero" size="6" value="<%=txtNumero%>"></p>  
            <p><label for="complemento">Complemento </label><input type="text" id="txtComplemento" name="txtComplemento" value="<%=txtComplemento%>"></p>  
            <p><label for="bairro">Bairro </label><input type="text" id="txtBairro" name="txtBairro" value="<%=txtBairro%>"  size="40"/></p>
            <p><label for="cidade">Cidade </label><input type="text" id="txtCidade" name="txtCidade" value="<%=txtCidade%>" size="40"/></p>
            <p><label for="estado">Estado </label><input type="text" id="txtEstado" name="txtEstado" value="<%=txtEstado%>" /></p> 
            <p><label for="pais">País </label><select name="txtPais">
                    <option id="argentina" name="txtPais" value="argentina">Argentina</option>
                    <option id="bolivia" name="txtPais" value="bolivia">Bolivia</option>
                    <option id="brasil" name="txtPais" value="brasil" selected>Brasil</option>
                    <option id="chile" name="txtPais" value="chile">Chile</option>
                    <option id="colombia" name="txtPais" value="colombia">Colombia</option>
                    <option id="equador" name="txtPais" value="equador">Equador</option>
                    <option id="guiana" name="txtPais" value="guiana">Guiana</option>
                    <option id="paraguai" name="txtPais" value="paraguai">Paraguai</option>
                    <option id="peru" name="txtPais" value="peru">Peru</option>
                    <option id="suriname" name="txtPais" value="suriname">Suriname</option>
                    <option id="uruguai" name="txtPais" value="uruguai">Uruguai</option>
                    <option id="venezuela" name="txtPais" value="venezuela">Venezuela</option>
            </select> 
            <p><label for="observacoes">Observações </label><input type="text" id="txtObservacoes" name="txtObservacoes" size="75" value="<%=txtObservacoes%>"/></p> 
            
            <input class="green"  type="submit" id="operacao" name="operacao" value="ALTERAR"/>
            <input type="hidden" id="uri" name="uri" value="AlterarEndereco"/>
            
        </fieldset>
    </form>
    <br>
    
    
    
    </body>
</html>