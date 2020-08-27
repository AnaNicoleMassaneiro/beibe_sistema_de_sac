/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Usuario;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tacid
 */
public class UsuarioFacade {
    private UsuarioFacade(){}
    
    public void alterarUsuario(Usuario usuario)  throws SQLException{
        new UsuarioDAO().alterar(usuario);
    }
    
    public void excluirUsuario(Usuario user)  throws SQLException{
        new UsuarioDAO().excluir(user);
    }        
    
    public boolean checkExisteUsuario(Usuario user)  throws SQLException{
        return new UsuarioDAO().existe(user);
    }        
    
    public void inserirUsuario(Usuario cliente)  throws SQLException{
        new UsuarioDAO().inserir(cliente);
    }        
    
    public List<Usuario> listarUsuario()  throws SQLException{
        return new UsuarioDAO().listar();
    }        
    
    public Usuario loginUsuario(Usuario user)  throws SQLException{
        return new UsuarioDAO().login(user);
    }       
    
    public Usuario buscarUltimoUsuario(String email) throws SQLException{
        return new UsuarioDAO().Buscar(email);
    }         
}
