
package domain;

public class Pessoa extends EntidadeDominio {
    
    protected String nome;
    protected Endereco endereco;
    
    public Pessoa(){}
    
    public Pessoa(String nome, Endereco endereco){
    this.nome = nome;
    this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
