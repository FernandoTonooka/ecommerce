package domain;

import java.util.Date;

public class EntidadeDominio {
    
    protected int id;
    protected Date dtCadastro;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
