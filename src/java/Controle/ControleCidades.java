/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloCidades;
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
public class ControleCidades {

    ControleBancoWEB controleBanco = new ControleBancoWEB();

    public boolean salvar(ModeloCidades cidade, ModeloEstados estado) {
        try {
            controleBanco.conecta();
            ControleEstados controleEstados = new ControleEstados();
            ModeloEstados estado2 = controleEstados.recebeNomeDevolveIdEstado(estado);
            PreparedStatement pst = controleBanco.conn.prepareStatement("insert into cidades (nome, id_estado)values(?,?)");
            pst.setString(1, cidade.getNome());
            pst.setInt(2, estado2.getId());
            pst.execute();
            controleBanco.desconecta();
            return true;
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleCidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return false;
    }

    public boolean alterar(ModeloCidades cidade) {
        try {
            controleBanco.conecta();
            controleBanco.execute("UPDATE cidades SET nome='" + cidade.getNome() + "' WHERE id='" + cidade.getId() + "'");
            controleBanco.desconecta();
            return true;
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleCidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return false;
    }

    public boolean excluir(ModeloCidades cidade) {
        try {
            controleBanco.conecta();
            controleBanco.execute("delete from cidades where id='" + cidade.getId() + "'");
            controleBanco.desconecta();
            return true;
        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleCidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return false;
    }

    public List<ModeloCidades> listarCidadesPorNome() {
        List cidades = new ArrayList();

        try {
            controleBanco.conecta();
            ResultSet rs = controleBanco.executarSqlVoltaResultSet("select * from cidades order by nome");

            if (!rs.next()) {
                ModeloCidades cidadeVazio = new ModeloCidades();
                cidadeVazio.setId(0);
                cidadeVazio.setNome("Sem dados na base");
                cidadeVazio.setId_estado(0);
                cidades.add(cidadeVazio);
            }
            rs.beforeFirst();
            while (rs.next()) {
                ModeloCidades cidade = new ModeloCidades();
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setId_estado(rs.getInt("id_estado"));

                cidades.add(cidade);
            }

        } catch (SQLException ex) {
            controleBanco.desconecta();
            Logger.getLogger(ControleCidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleBanco.desconecta();
        return cidades;
    }

}
