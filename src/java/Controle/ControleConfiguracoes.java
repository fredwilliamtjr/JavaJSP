/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloConfiguracoes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fredw
 */
public class ControleConfiguracoes {

    ControleBancoWEB controleConfiguracoes = new ControleBancoWEB();
    ModeloConfiguracoes configuracoes = new ModeloConfiguracoes();

    public ModeloConfiguracoes getConfiguracoes() {
        configuracoes.setCor("steelblue");
        try {
            controleConfiguracoes.conecta();
            controleConfiguracoes.executeQuery("select cor from configuracoes");
            controleConfiguracoes.rs.first();
            configuracoes.setCor(controleConfiguracoes.rs.getString("cor")); 
            System.out.println("Pegou a Cor!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ControleConfiguracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleConfiguracoes.desconecta();
        return configuracoes;
    }

}
