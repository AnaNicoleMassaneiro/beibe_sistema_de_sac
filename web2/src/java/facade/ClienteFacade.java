/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Usuario;
import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tacid
 */
public class ClienteFacade {
    private ClienteFacade(){}
    
    public void alterarCliente(Usuario cliente) throws SQLException{
        new ClienteDAO().alterar(cliente);
    }
    
    public void excluirCliente(Usuario cliente)  throws SQLException{
        new ClienteDAO().excluir(cliente);
    }
    
    public boolean checkExisteCliente(Usuario user)  throws SQLException{
        return new ClienteDAO().existe(user);
    }
    
    public Usuario buscarClienteById(int id)  throws SQLException{
        return new ClienteDAO().Buscar(id);
    }
    
    public List<Usuario> listarClientes()  throws SQLException{
        return new ClienteDAO().listar();
    }
    
    public Usuario loginCliente(Usuario user)  throws SQLException{
        return new ClienteDAO().login(user);
    }
    
    public int getUltimoCliente()  throws SQLException{
        return new ClienteDAO().Ultimo();
    }        
}
