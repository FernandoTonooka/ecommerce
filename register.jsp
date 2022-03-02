<%-- 
    Document   : register
    Created on : Mar 1, 2022, 9:51:24 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
        <title>Início</title>
        <link rel="stylesheet" href="/LES_Projeto/css/bootstrap.min.css">
        <script src="/LES_Projeto/js/jquery.min.js"></script>
        <script src="/LES_Projeto/js/popper.min.js"></script>
        <script src="/LES_Projeto/js/jquery.mask.min.js"></script>
        <script src="/LES_Projeto/js/bootstrap.min.js"></script>
        <script src="/LES_Projeto/js/validator.js"></script> 
        <script src="/LES_Projeto/js/principal.js"></script> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <div class="container-fluid">
        <div style=" width: 100%; justify-content: left;
        display: flex;
        align-items: left;
        justify-content: center;">
            
        <form action="Cliente.jsp" style="width: 530px;
        min-width: 530px; border: solid 3px; border-color: rgba(23,162,184,1);
        padding: 15px; border-radius: 10px;" method="post">
           
            <div class="form-group row">
                <div class="col-sm-12">
                    <h2 style="font-family: sans-serif; color: #0c5460">Cadastrar Nova Conta</h2>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-3">
                    <label class="col-sm-3" for="txtCpf" style="font-family: sans-serif; font-size: 24px; color: teal">CPF</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" name="txtCpf" id="txtCpf" onfocus="javascript: retirarFormatacao(this);" onblur="javascript: formatarCampo(this);" class="form-control"
                    placeholder="CPF"
                    data-error="CPF Obrigatório!" required id="txtCpf"/>
                    <div class="help-block with-errors" style="color: red;"></div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-3">
                    <label class="col-sm-3" for="txtEmail" style="font-family: sans-serif; font-size: 24px; color: teal">Email</label>
                </div>
                <div class="col-sm-9">
                    <input type="text" name="txtEmail" id="txtEmail" class="form-control"
                    placeholder="E-mail"
                    data-error="E-mail Obrigatório!" required id="txtEmail"/>
                    <div class="help-block with-errors" style="color: red;"></div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-3">
                    <label class="col-sm-3" for="txtSenha" style="font-family: sans-serif; font-size: 24px; color: teal">Senha</label>
                </div>
                <div class="col-sm-9">
                    <input type="password" name="txtSenha" id="txtSenha"  class="form-control"
                    placeholder="Digite sua senha"
                    data-error="Senha Obrigatória!" required id="txtSenha"/>
                    <div class="help-block with-errors" style="color: red;"></div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-3">
                    <label class="col-sm-3" for="txtConfirmaSenha" style="font-family: sans-serif; font-size: 24px; color: teal">Senha</label>
                </div>
                <div class="col-sm-9">
                    <input type="password" name="txtConfirmaSenha" id="txtConfirmaSenha"  class="form-control"
                    placeholder="Repita sua senha" onblur="javascript: validarSenha()"
                    data-error="Senha Obrigatória!" required id="txtConfirmaSenha"/>
                    <div class="help-block with-errors" style="color: red;"></div>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-3">
                 <input type="submit" id="operacao" name="operacao" value="CADASTRAR" class="btn btn-xs btn btn-success btn-sm"/>
                 <input type="hidden" id="uri" name="uri" value="CadastrarCliente"/>
                </div>
                <div class="col-sm-3" style="text-align: right;" >
                    <a href="/LES_Projeto/index.html" class="btn btn-xs btn btn-primary btn-sm">PÁGINA INICIAL</a>
                </div>
           </div>   
           </form>
    </body>
<!-- comment</html>
    <h1>Novo Cliente</h1>  
    <form action="Controller" method="post">  
        <fieldset style="width: 50%; position: "> 
            <legend>Dados do Cliente</legend>
            <p><label for="nome">Nome </label><input type="text" id="txtNome" name="txtNome" size="40"/></p>
            <p><label for="genero">Gênero</label>
            <input type="radio" id="feminino" name="txtGenero" value="feminino"><label for="nome">Feminino </label>
            <input type="radio" id="masculino" name="txtGenero" value="masculino"><label for="nome">Masculino </label>
            <input type="radio" id="outro" name="txtGenero" value="outro"><label for="nome">Outro </label></p>
            <p><label for="dtnascimento">Data de Nascimento </label><input type="date" id="txtDtNascimento" name="txtDtNascimento" /></p>  
            <p><label for="cpf">CPF </label><input type="text" id="txtCpf" name="txtCpf" onfocus="javascript: retirarFormatacao(this);" onblur="javascript: formatarCampo(this);" maxlength="14"/></p>  
            <p><label for="telefone">Telefone </label><input type="text" id="txtTelefone" name="txtTelefone" maxlenght="15"/></p>  
            <p><label for="email">E-mail </label><input type="text" id="txtEmail" name="txtEmail" size="40"/></p>
            <p><label for="senha">Senha </label><input type="password" id="txtSenha" name="txtSenha" size="10"/></p>
             
            <input class="green" type="submit" id="operacao" name="operacao" value="SALVAR"/>
            <input type="hidden" id="uri" name="uri" value="SalvarCliente"/>
            
        </fieldset>
    </form>  
    <br/>  
    
    <a class="blue" href="Controller?operacao=CONSULTAR&uri=ConsultarCliente">Lista de Clientes</a>
    <a class="blue" href="Controller?operacao=CONSULTAR&uri=ConsultarEndereco">Lista de Endereços</a>
    </body>
-->
</html>
