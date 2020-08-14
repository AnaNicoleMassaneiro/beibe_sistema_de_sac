package beans.enums;

/**
 *
 * @author Leonardo
 */
public enum Perfil {
    CLIENTE("Cliente"), FUNCIONARIO("Funcionário"), GERENTE("Gerente");
    
    private final String nomePerfil;
    
    Perfil(String nomePerfil){
        this.nomePerfil = nomePerfil;
    }
    
    public String getNomePerfil(){
        return nomePerfil;
    }    
    
}
