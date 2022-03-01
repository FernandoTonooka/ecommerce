
package domain;

public class Pais {
    
    private String descricao; 
    
    public Pais(){}
    
    public Pais(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
