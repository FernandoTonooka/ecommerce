//FORMATAÇÃO CPF
function formatarCampo(campoTexto) {
    if (campoTexto.value.length <= 11) {
        campoTexto.value = mascaraCpf(campoTexto.value);
    } else {
        campoTexto.value = mascaraCnpj(campoTexto.value);
    }
}
            
function retirarFormatacao(campoTexto) {
    campoTexto.value = campoTexto.value.replace(/(\.|\/|\-)/g,"");
}

function mascaraCpf(valor) {
    return valor.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g,"\$1.\$2.\$3\-\$4");
}

function mascaraCnpj(valor) {
    return valor.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/g,"\$1.\$2.\$3\/\$4\-\$5");
}

//FORMATAÇÃO TELEFONE
function mascaraTelefone(o,f){
    v_obj=o;
    v_fun=f;
    setTimeout("execMascaraTel()",1);
}

function execMascaraTel(){
    v_obj.value=v_fun(v_obj.value);
}

function mtel(v){
    v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}

function id( el ){
    return document.getElementById( el );
}

window.onload = function(){
    id('txtTelefone').onkeypress = function(){
            mascaraTelefone( this, mtel );
    };
}

//BUSCA CEP
function limpa_formulário_cep() {
    //Limpa valores do formulário de cep.
    document.getElementById('txtLogradouro').value=("");
    document.getElementById('txtBairro').value=("");
    document.getElementById('txtCidade').value=("");
    document.getElementById('txtEstado').value=("");
}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        document.getElementById('txtLogradouro').value=(conteudo.logradouro);
        document.getElementById('txtBairro').value=(conteudo.bairro);
        document.getElementById('txtCidade').value=(conteudo.localidade);
        document.getElementById('txtEstado').value=(conteudo.uf);
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulário_cep();
        alert("CEP não encontrado.");
    }
}

function pesquisacep(valor) {

    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

    //Expressão regular para validar o CEP.
    var validacep = /^[0-9]{8}$/;

    //Valida o formato do CEP.
    if(validacep.test(cep)) {

        //Preenche os campos com "..." enquanto consulta webservice.
        document.getElementById('txtLogradouro').value="...";
        document.getElementById('txtBairro').value="...";
        document.getElementById('txtCidade').value="...";
        document.getElementById('txtEstado').value="...";
        
        //Cria um elemento javascript.
        var script = document.createElement('script');

        //Sincroniza com o callback.
        script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

        //Insere script no documento e carrega o conteúdo.
        document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep();
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulário_cep();
    }
};

function validarSenha(){
    senha = document.getElementById("txtSenha").value;
    confirmaSenha = document.getElementById("txtConfirmaSenha").value;
    if(senha !== confirmaSenha){
        alert("Senha não confere! Digite novamente!");
    }else{
        return;
    }
}
