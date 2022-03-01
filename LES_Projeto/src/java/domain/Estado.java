
package domain;

public class Estado {
    
    private String descricao;
    private Pais pais;
    
    public Estado(){}

    public Estado(String descricao, Pais pais){
        this.descricao = descricao;
        this.pais = pais;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Pais getPais() {
        return pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
