/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ana Nicole
 */
public class ConnectionFactory {

    public Connection getConexao() {
        Connection conexao = null;
        String usuario = "postgres";
        String senha = "123456";
        String nomeBancoDados = "agoraVai";

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBancoDados,
                    usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
}
