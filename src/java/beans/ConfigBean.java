package beans;

import java.io.Serializable;

public class ConfigBean implements Serializable {
    private String email;

    public ConfigBean() {
    }

    public ConfigBean(String email) {
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
}
