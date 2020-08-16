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
import beans.TipoUsuario;
import java.sql.SQLException;

/**
 *
 * @author Ana Nicole
 */
public class UsuarioDAO extends ConnectionFactory {

    public UsuarioDAO() {
    }

    public void alterar(Usuario usuario) {
        try {
            try (Connection conexao = getConexao()) {
                PreparedStatement pstmt;
                pstmt = conexao
                        .prepareStatement("Update usuario SET nome = ?, senha = ?, telefone = ?, cidade = ?, cep = ?, bairro = ?, rua = ?, numero = ?, complemento = ? where email = ? ");
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getSenha());
                pstmt.setString(3, usuario.getTel());
                pstmt.setInt(4, usuario.getCidade());
                pstmt.setString(5, usuario.getCep());
                pstmt.setString(6, usuario.getBairro());
                pstmt.setString(7, usuario.getRua());
                pstmt.setInt(8, usuario.getNr());
                pstmt.setString(9, usuario.getComplemento());
                pstmt.setString(10, usuario.getEmail());

                pstmt.execute();
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluir(Usuario user) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Delete from usuario where email = ? ")) {
                pstm.setString(1, user.getEmail());
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

    public void inserir(Usuario cliente) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstmt = conexao.prepareStatement("Insert into usuario (perfil,nome,email,senha,cpf,telefone,cidade,bairro,cep,rua,numero,complemento) values (?,?,?,?,?,?,?,?,?,?,?,?)")) {

                pstmt.setInt(1, cliente.getPerfilId());
                pstmt.setString(2, cliente.getNome());
                pstmt.setString(3, cliente.getEmail());
                pstmt.setString(4, cliente.getSenha());
                pstmt.setString(5, cliente.getCpf());
                pstmt.setString(6, cliente.getTel());
                pstmt.setInt(7, cliente.getCidade());
                pstmt.setString(8, cliente.getBairro());
                pstmt.setString(9, cliente.getCep());
                pstmt.setString(10, cliente.getRua());
                pstmt.setInt(11, cliente.getNr());
                pstmt.setString(12, cliente.getComplemento());
                pstmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Usuario> listar() {
        PreparedStatement pstm;
        List<Usuario> lista = new ArrayList<>();
        Usuario user;
        TipoUsuario tipo;
        try {
            try (Connection conexao = getConexao(); Statement stm = conexao.createStatement()) {
                ResultSet rs = stm.executeQuery("Select * from usuario where perfil <> 1");
                ResultSet rst;
                while (rs.next()) {
                    user = new Usuario();
                    user.setCpf(rs.getString("cpf"));
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setPerfil(rs.getInt("perfil"));

                    pstm = conexao.prepareStatement("select * from tipousuario where id = ?");
                    pstm.setInt(1, user.getPerfilId());
                    rst = pstm.executeQuery();
                    if (rst.next()) {
                        tipo = new TipoUsuario();
                        tipo.setId(user.getPerfilId());
                        tipo.setNome(rst.getString("nome"));
                        user.setPerfil(tipo);
                    }
                    lista.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println("Listar: " + e);
        }
        return lista;
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
                    user.setPerfil(rs.getInt("perfil"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public Usuario Buscar(String email) {
        Usuario usuario = new Usuario();
        TipoUsuario tipo;
        PreparedStatement stm;
        ResultSet rst;
        try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select * from usuario WHERE email = ?")) {
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                usuario.setPerfil(rs.getInt("perfil"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTel(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRua(rs.getString("rua"));
                usuario.setNr(rs.getInt("numero"));
                usuario.setCep(rs.getString("cep"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getInt("cidade"));
                usuario.setComplemento(rs.getString("complemento"));

                stm = conexao.prepareStatement("select * from tipousuario where id = ?");
                stm.setInt(1, usuario.getPerfilId());
                rst = stm.executeQuery();
                if (rst.next()) {
                    tipo = new TipoUsuario();
                    tipo.setId(usuario.getPerfilId());
                    tipo.setNome(rst.getString("nome"));
                    usuario.setPerfil(tipo);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select estado from cidade where id = ?")) {
            pstm.setInt(1, usuario.getCidade());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                usuario.setUf(rs.getInt("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }
}
