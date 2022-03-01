
package domain;

import java.sql.Connection;

public class Endereco extends EntidadeDominio {
    private int id;
    private String tpEndereco;
    private String tpResidencia;
    private String tpLogradouro;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;
    private Estado estado;
    private Pais pais;
    private String observacoes;
    private Cliente cliente;
    
    public Endereco() { }
    
    public Endereco(int id) { 
        this.id = id;
    }
    
    public Endereco(Cliente cliente) { 
        this.cliente = cliente;
    }
    
    public Endereco(int id, Cliente cliente) { 
        this.id = id;
        this.cliente = cliente;
    }
    
    public Endereco (int id, String tpEndereco, String tpResidencia, String tpLogradouro, String cep, String logradouro, String numero, String complemento, String bairro, Cidade cidade, Estado estado, Pais pais, String observacoes, Cliente cliente){
        this.id = id;
        this.tpEndereco = tpEndereco;
        this.tpResidencia = tpResidencia;
        this.tpLogradouro = tpLogradouro;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.observacoes = observacoes;
        this.cliente = cliente;
    }
    
    public Endereco (String tpEndereco, String tpResidencia, String tpLogradouro, String cep, String logradouro, String numero, String complemento, String bairro, Cidade cidade, Estado estado, Pais pais, String observacoes, Cliente cliente){
        this.tpEndereco = tpEndereco;
        this.tpResidencia = tpResidencia;
        this.tpLogradouro = tpLogradouro;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.observacoes = observacoes;
        this.cliente = cliente;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTpEndereco() {
        return tpEndereco;
    }

    public void setTpEndereco(String tpEndereco) {
        this.tpEndereco = tpEndereco;
    }
    
    public String getTpResidencia() {
        return tpResidencia;
    }

    public void setTpResidencia(String tpResidencia) {
        this.tpResidencia = tpResidencia;
    }

    public String getTpLogradouro() {
        return tpLogradouro;
    }

    public void setTpLogradouro(String tpLogradouro) {
        this.tpLogradouro = tpLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }
    
    public void setCidade ( Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void salvar(Connection connection) {
        
    }
}
    

