/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Ana Nicole
 */
public class ClienteDAO extends ConnectionFactory {

    public void alterar(Usuario cliente) {
        try {
            try (Connection conexao = getConexao()) {
                PreparedStatement pstmt;
                pstmt = conexao
                        .prepareStatement("Update tb_cliente SET cpf_cliente = ?, nome_cliente = ?, email_cliente = ?, rua_cliente = ?, nr_cliente = ?, cep_cliente = ?, cidade_cliente = ?, uf_cliente = ? where id = ? ");
                pstmt.setString(1, cliente.getCpf());
                pstmt.setString(2, cliente.getNome());
                pstmt.setString(3, cliente.getEmail());
                pstmt.setString(4, cliente.getRua());
                pstmt.setInt(5, cliente.getNr());
                pstmt.setString(6, cliente.getCep());
                pstmt.setInt(7, cliente.getCidade());
                pstmt.setInt(8, cliente.getUf());
                
                pstmt.execute();
                pstmt.close();
            }

        } catch (SQLException e) {
        }
    }

    public void excluir(Usuario cliente) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Delete from Usuario where email = ? ")) {
                pstm.setString(1, cliente.getEmail());
                pstm.execute();
            }
        } catch (SQLException e) {
        }
    }

    public boolean existe(Usuario user) {
        boolean achou = false;
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from tb_usuario where login_usuario =	?")) {
                //pstm.setString(1, user.getLogin());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    achou = true;
                }
            }
        } catch (SQLException e) {
        }
        return achou;
    }

   

    public Usuario Buscar(int id) {
        Usuario usuario = new Usuario();
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select * from usuario where id = ?")) {
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    usuario.setNome(rs.getString("nome_cliente"));
                    usuario.setCpf(rs.getString("cpf_cliente"));
                    usuario.setEmail(rs.getString("email_cliente"));
                    usuario.setRua(rs.getString("rua_cliente"));
                    usuario.setNr(rs.getInt("nr_cliente"));
                    usuario.setCep(rs.getString("cep_cliente"));
                    usuario.setCidade(rs.getInt("cidade_cliente"));
                    usuario.setUf(rs.getInt("uf_cliente"));
                }
            }
        } catch (SQLException e) {
        }
        return usuario;
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            try (Connection conexao = getConexao(); Statement stm = conexao.createStatement()) {
                ResultSet rs = stm.executeQuery("Select * from tb_cliente order by (id)");
                while (rs.next()) {
                    Usuario cliente = new Usuario();
                    cliente.setNome(rs.getString("nome_cliente"));
                    cliente.setCpf(rs.getString("cpf_cliente"));
                    cliente.setEmail(rs.getString("email_cliente"));
                    cliente.setRua(rs.getString("rua_cliente"));
                    cliente.setNr(rs.getInt("nr_cliente"));
                    cliente.setCep(rs.getString("cep_cliente"));
                    cliente.setCidade(rs.getInt("cidade_cliente"));
                    cliente.setUf(rs.getInt("uf_cliente"));
                    
                    lista.add(cliente);
                }
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public Usuario login(Usuario user) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from tb_usuario where login_usuario = ? and senha_usuario = ?")) {
                //pstm.setString(1, user.getLogin());
                //pstm.setString(2, user.getSenha());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    user.setNome(rs.getString("nome_usuario"));
                    //  user.setLogin(rs.getString("login_usuario"));
                    // user.setSenha(rs.getString("senha_usuario"));
                }
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public int Ultimo() {
        int ultimo=0;
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select max (id) from tb_cliente")) {
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    ultimo = rs.getInt("max");
                }
            }
        } catch (SQLException e) {
        }
        return ultimo;
    }
}
