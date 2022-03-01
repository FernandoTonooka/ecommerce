<%-- 
    Document   : index
    Created on : Aug 16, 2021, 10:42:19 PM
    Author     : fernandotonooka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
        <title>Cadastro de Cliente</title>
        <link rel="stylesheet" href="css/padrao.css?123456789" type="text/css">
        <script type="text/javascript" src="js/principal.js?123456789"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <script src="view-source:https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="bg">
        <h1 align="center">Seja Bem-Vindo!</h1>
      
            <table border="0" width="100%" cellpadding="10">
            <tr>
                
                <form action="Controller" method="post"> 
                <td width="50%" valign="top">
                    <h2 align="center">Já sou cadastrado</h2>
                    <label class="login">CPF</label><br>
                    <input type="text" id="txtCpf" name="txtCpf" onfocus="javascript: retirarFormatacao(this);" onblur="javascript: formatarCampo(this);" maxlength="14" placeholder="Digite seu CPF"/><br>
                    <label class="login">Senha</label><br>
                    <input type="password" id="txtSenha" name="txtSenha" placeholder="Digite sua senha"/><br>
                    <label class="login">Confirme sua Senha</label><br>
                    <input type="password" id="txtConfirmaSenha" name="txtConfirmaSenha" placeholder="Repita sua senha" onblur="javascript: validarSenha()"/><br><br>
                    <input type="submit" id="operacao" name="operacao" value="CONSULTAR"/>
                    <input type="hidden" id="uri" name="uri" value="EntrarCliente"/>
                </td>
                </form>

                <form action="Cliente.jsp" method="post"> 
                <td width="50%" valign="top">
                    <h2 align="center">Quero me cadastrar</h2>
                    <label class="login">CPF</label><br>
                    <input type="text" id="txtCpf" name="txtCpf" onfocus="javascript: retirarFormatacao(this);" onblur="javascript: formatarCampo(this);" maxlength="14" placeholder="Digite seu CPF"/><br>
                    <label class="login">E-mail</label><br>
                    <input type="text" id="txtEmail" name="txtEmail" placeholder="Digite seu e-mail" /><br>
                    <label class="login">Senha</label><br>
                    <input type="password" id="txtSenha" name="txtSenha" placeholder="Crie uma senha" /><br>
                    <label class="login">Confirme sua Senha</label><br>
                    <input type="password" id="txtConfirmaSenha" name="txtConfirmaSenha" placeholder="Repita sua senha" onblur="javascript: validarSenha()"/><br><br>
                    <input type="submit" id="operacao" name="operacao" value="CADASTRAR"/>
                    <input type="hidden" id="uri" name="uri" value="CadastrarCliente"/>
                </td>
                </form>
            
            </tr>
            </table>
    <a class="blue" href="Controller?operacao=CONSULTAR&uri=ConsultarCliente">Lista de Clientes</a>

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
