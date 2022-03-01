
package domain;

import java.time.LocalDate;

public class Cartao extends EntidadeDominio {
    private int id;
    private String bandeira;
    private String nome;
    private String numero;
    private LocalDate validade;
    private String cvv;
    private Cliente cliente;


public Cartao(){}

public Cartao(int id) {
    this.id = id;
}

public Cartao(Cliente cliente) {
    this.cliente=cliente;
}

public Cartao(int id, Cliente cliente) {
    this.id=id;
    this.cliente = cliente;
}

public Cartao(String bandeira, String nome, String numero, LocalDate validade, String cvv, Cliente cliente){
    this.bandeira = bandeira;
    this.nome = nome;
    this.numero = numero;
    this.validade = validade;
    this.cvv = cvv;
    this.cliente = cliente;
}

public Cartao(int id, String bandeira, String nome, String numero, LocalDate validade, String cvv, Cliente cliente){
    this.id = id;
    this.bandeira = bandeira;
    this.nome = nome;
    this.numero = numero;
    this.validade = validade;
    this.cvv = cvv;
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

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}



