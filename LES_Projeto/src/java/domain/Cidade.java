
package domain;

public class Cidade extends EntidadeDominio {
    
    private String descricao;
    private Estado estado;
    
    public Cidade(){}
    
    public Cidade(String descricao, Estado estado){
        this.descricao = descricao;
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
