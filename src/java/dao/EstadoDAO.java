package dao;

import beans.Estado;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements DAO<Estado> {

    private static final String QUERY_BUSCAR_TODOS = "SELECT id_estado, sigla_estado, nome_estado FROM tb_estado";
    private static final String QUERY_BUSCAR = "SELECT id_estado, sigla_estado, nome_estado FROM tb_estado WHERE id_estado = ?";

    private Connection con = null;

    public EstadoDAO() throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    @Override
    public Estado buscar(int id) throws DAOException {
        Estado estado = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getInt("id_estado"));
                estado.setSigla(rs.getString("sigla_estado"));
                estado.setNome(rs.getString("nome_estado"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando estado: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return estado;
    }

    @Override
    public List<Estado> buscarTodos() throws DAOException {
        List<Estado> estados = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estado e = new Estado();
                e.setId(rs.getInt("id_estado"));
                e.setSigla(rs.getString("sigla_estado"));
                e.setNome(rs.getString("nome_estado"));
                estados.add(e);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os estados: " + QUERY_BUSCAR_TODOS, e);
        }
        return estados;
    }

    @Override
    public void inserir(Estado t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Estado t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Estado t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
