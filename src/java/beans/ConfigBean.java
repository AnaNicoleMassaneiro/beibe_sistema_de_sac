/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Ana
 */
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
