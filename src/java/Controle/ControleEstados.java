/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloEstados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fredw
 */
public class ControleEstados {

    ControleBancoWEB controleBanco = new ControleBancoWEB();
    

    public boolean salvar(ModeloEstados estado) {
        try {
            controleBanco.conecta();
            PreparedStatement pst = controleBanco.conn.prepareStatement("insert into estados (nome, sigla)values(?,?)");
            pst.setString(1, estado.getNome());
            pst.setString(2, estado.getSigla());
            pst.execute();
            controleBanco.desconecta();
            return true;
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return false;
    }

    public boolean alterar(ModeloEstados estado) {
        try {
            controleBanco.conecta();
            controleBanco.execute("UPDATE estados SET nome='"+estado.getNome()+"', sigla='"+estado.getSigla()+"'  WHERE id='"+estado.getId()+"'");
            controleBanco.desconecta();
            return true;
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return false;
    }

    public boolean excluir(ModeloEstados estado) {
        try {
            controleBanco.conecta();
            controleBanco.execute("delete from estados where id='" + estado.getId() + "'");
            controleBanco.desconecta();
            return true;
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return false;
    }

    public List<ModeloEstados> listarEstadosUF() {
        List estados = new ArrayList();

        try {
            controleBanco.conecta();
            ResultSet rs = controleBanco.executarSqlVoltaResultSet("select * from estados order by sigla");

            if (!rs.next()) {
                ModeloEstados estadoVazio = new ModeloEstados();
                estadoVazio.setId(0);
                estadoVazio.setNome("Sem dados na base");
                estadoVazio.setSigla("ND");
                estados.add(estadoVazio);
            }
            rs.beforeFirst();
            while (rs.next()) {
                ModeloEstados estado = new ModeloEstados();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));

                estados.add(estado);
            }

        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return estados;
    }


    public List<ModeloEstados> listarEstadosNome() {
        List estados = new ArrayList();

        try {
            controleBanco.conecta();
            ResultSet rs = controleBanco.executarSqlVoltaResultSet("select * from estados order by nome");

            if (!rs.next()) {
                ModeloEstados estadoVazio = new ModeloEstados();
                estadoVazio.setId(0);
                estadoVazio.setNome("Sem dados na base");
                estadoVazio.setSigla("ND");
                estados.add(estadoVazio);
            }
            rs.beforeFirst();
            while (rs.next()) {
                ModeloEstados estado = new ModeloEstados();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));

                estados.add(estado);
            }

        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return estados;
    }
    
    public ModeloEstados recebeNomeDevolveIdEstado (ModeloEstados estado){
        try {
            controleBanco.conecta();
            ResultSet rs = controleBanco.executarSqlVoltaResultSet("select * from estados where nome='"+estado.getNome()+"'");
            rs.first();        
            estado.setId(rs.getInt("id"));
            controleBanco.desconecta();
            return estado;
            
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return estado;
    }

    public ModeloEstados recebeIdDevolveNomeEstado (ModeloEstados estado){
        try {
            controleBanco.conecta();
            ResultSet rs = controleBanco.executarSqlVoltaResultSet("select * from estados where id='"+estado.getId()+"'");
            rs.first();        
            estado.setNome(rs.getString("nome"));
            controleBanco.desconecta();
            return estado;
            
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return estado;
    }


}
