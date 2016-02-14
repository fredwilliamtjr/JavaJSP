/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloUsuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fredw
 */
public class ControleUsuarios {
    
    ControleBancoWEB controleUsuarios = new ControleBancoWEB();
     ModeloUsuarios modeloUsuarios = new ModeloUsuarios();
    
        public boolean login(ModeloUsuarios usuario) {
        boolean podelogar = false;
        try {
            controleUsuarios.conecta();
            controleUsuarios.executeQuery("select * from usuarios where login = '" + usuario.getLogin() + "' and senha = '" + usuario.getSenha() + "'");
            podelogar = controleUsuarios.rs.first();
            System.out.println("Verificando Login!!!");
        } catch (SQLException ex) {
            
            Logger.getLogger(ControleBancoWEB.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleUsuarios.desconecta();
        return podelogar;
    }

    
}
