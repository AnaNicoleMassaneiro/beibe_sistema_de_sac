package beans;

import java.io.Serializable;

public class LoginBean implements Serializable{
    private String login, nome;

    public LoginBean() {
    }

    public LoginBean(String login, String nome) {
        this.login = login;
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   
    
}
