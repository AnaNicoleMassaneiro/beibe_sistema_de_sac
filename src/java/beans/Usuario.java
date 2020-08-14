package beans;

import java.io.Serializable;

/**
 *
 * @author Ana
 */
public class Usuario implements Serializable{
    private int nr, cidade, uf;
    private String cpf, nome, email, rua, cep, senha, tel, bairro, complemento;
    private TipoUsuario perfil;
    
    public Usuario() {
    }

    public Usuario(int nr, TipoUsuario perfil, String cpf, String nome, String email, String rua, String cep, int cidade, int uf, String senha, String tel, String bairro, String complemento) {
        this.nr = nr;
        this.perfil = perfil;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.rua = rua;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.senha = senha;
        this.tel = tel;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public TipoUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(TipoUsuario perfil) {
        this.perfil = perfil;
    }
    
    public int getPerfilId() {
        return perfil.getId();
    }

    public void setPerfil(int perfil) {
        this.perfil = new TipoUsuario(perfil);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
