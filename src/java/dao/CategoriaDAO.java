/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Categoria;
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
public class CategoriaDAO extends ConnectionFactory {

    public CategoriaDAO() {
    }

    public void alterar(Categoria categoria) {
        try {
            try (Connection conexao = getConexao()) {
                PreparedStatement pstmt;
                pstmt = conexao
                        .prepareStatement("Update categoria SET nome = ? where id = ? ");
                pstmt.setString(1, categoria.getNome());
                pstmt.setInt(2, categoria.getId());

                pstmt.execute();
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluir(int id) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Delete from categoria where id = ? ")) {
                pstm.setInt(1, id);
                pstm.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean existe(Usuario user) {
        boolean achou = false;
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where email =	?")) {
                pstm.setString(1, user.getEmail());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    achou = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return achou;
    }

    public void inserir(Categoria categoria) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstmt = conexao.prepareStatement("Insert into categoria (nome,id) values (?,?)")) {

                pstmt.setString(1, categoria.getNome());
                pstmt.setInt(2, categoria.getId());
                pstmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        Categoria c;
        try {
            try (Connection conexao = getConexao(); Statement stm = conexao.createStatement()) {
                ResultSet rs = stm.executeQuery("Select * from categoria ORDER BY id");
                while (rs.next()) {
                    c = new Categoria();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public Usuario consultar(Usuario user) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where email = ? and senha = ?")) {
                pstm.setString(1, user.getEmail());
                pstm.setString(1, user.getSenha());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setSenha(rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public Usuario login(Usuario user) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where email = ? and senha = ?")) {
                pstm.setString(1, user.getEmail());
                pstm.setString(2, user.getSenha());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setSenha(rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public Categoria Buscar(int id) {
        Categoria categoria = new Categoria();
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select * from categoria where id = ?")) {
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    categoria.setId(rs.getInt("id"));
                    categoria.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return categoria;
    }
     public int Ultimo() {
        int ultimo = 0;
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select max (id) from categoria")) {
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    ultimo = rs.getInt("max");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ultimo;
    }
}
