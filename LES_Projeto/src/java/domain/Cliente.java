
package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa {

    private int id;
    private String nome;
    private String genero;
    private LocalDate dtNascimento;
    private String cpf;
    private  String telefone;
    private String email;
    private String senha;
    private ArrayList<Endereco> enderecos;
    private ArrayList<Cartao> cartoes;
    
    public Cliente(){}
    
    public Cliente(int id) {
    this.id=id;   
    enderecos = new ArrayList<>();
    cartoes = new ArrayList<>();
    }
    
    public Cliente(String cpf, String senha) {
    this.cpf=cpf;
    this.senha=senha;
    enderecos = new ArrayList<>();
    cartoes = new ArrayList<>();
    }
    
    public Cliente(String nome, String genero, LocalDate dtNascimento,String cpf, String telefone, String email,String senha, ArrayList<Endereco> enderecos, ArrayList<Cartao> cartoes){
    this.nome=nome;
    this.genero=genero;
    this.dtNascimento=dtNascimento;
    this.cpf=cpf;
    this.telefone=telefone;
    this.email=email;
    this.senha=senha;
    enderecos = new ArrayList<>();
    cartoes = new ArrayList<>();
    }
    
    public Cliente(int id, String nome, String genero, LocalDate dtNascimento,String cpf, String telefone, String email,String senha, ArrayList<Endereco> enderecos, ArrayList<Cartao> cartoes){
    this.id=id;
    this.nome=nome;
    this.genero=genero;
    this.dtNascimento=dtNascimento;
    this.cpf=cpf;
    this.telefone=telefone;
    this.email=email;
    this.senha=senha;
    enderecos = new ArrayList<>();
    cartoes = new ArrayList<>();
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void AdicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }
    
    public void ExcluirEndereco (Endereco endereco) {
        enderecos.remove(endereco);
    }
    
    public Endereco getEndereco(int id){
        return enderecos.get(id);
    }
    
    
}
