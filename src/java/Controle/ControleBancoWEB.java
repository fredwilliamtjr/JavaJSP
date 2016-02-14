/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public class ControleBancoWEB {

    public Statement stm; //responsavel por preparar e realizar pesquisas no banco, onde passa o sql
    public ResultSet rs; // responsavel por armazenar o resoltudo de uma pesquisa passa para o stm
    public Connection conn; // responsavel por realizar a conecta com o banco.
    private String caminho = "jdbc:postgresql://localhost:5434/"; // responsavel por  setar o local do banmco
    private String usuario = "postgres";
    private String senha = "postgres";
    private String banco = "sistemawebteste";

    public Connection conecta() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(caminho + banco, usuario, senha);
                System.out.println("Conectado com Sucesso!!!");
            } catch (SQLException ex) {
                Logger.getLogger(ControleBancoWEB.class.getName()).log(Level.SEVERE, null, ex);
                System.out.printf("Caminho, senha ou usuario incorretos");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleBancoWEB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.printf("Driver não encontrado");
        }
        return conn;
    }

    public void desconecta() { //metodo para fechar a conecta com o banco.
        try {
            conn.close();
            System.out.println("Desconectado com Sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ControleBancoWEB.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void executeQuery(String sql) {
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControleBancoWEB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public ResultSet executarSqlVoltaResultSet(String sql) {
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControleBancoWEB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    
        public boolean execute(String sql) {
            boolean executou = false;
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            executou = stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControleBancoWEB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executou;
    }

}
