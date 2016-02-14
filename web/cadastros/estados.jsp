<%-- 
    Document   : corpo
    Created on : 06/11/2015, 19:15:30
    Author     : fredw
--%>

<%@page import="Modelo.ModeloEstados"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Controle.ControleEstados"%>
<%@page import="Controle.ControleConfiguracoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Estados</title>
        <link rel="stylesheet" href="../estilo.css"
    </head>
    <body id=<%=application.getAttribute("cor").toString()%>>
    <center><h1>Cadastro de estados</h1></center>
    <div id="salvar">
        <form name="salvarEstado" action="../EstadoSalvar"><input type="hidden" name="pagina" value="estados" />
            <h3>Nome: <input type="text" name="nome" value="" /></h3>
            <h3>Sigla: <input type="text" name="sigla" value="" /></h3>
            <input type="submit" value="Salvar" name="btnSalvar" />
        </form>
    </div>
    <div id="lista">
        
            <center>
                <table border="1">
                    <tr>

                        <td><center>Estado</center></td>
                    <td><center>UF</center></td>

                    </tr>

                    <%
                        ControleEstados estados = new ControleEstados();
                        
                        List<ModeloEstados> lista = estados.listarEstadosUF();
                        
                        for (int i = 0; i < lista.size(); i++) {  
                            out.println("<tr>");
                            out.println("<form name='listaEstadosAlterar' action='../EstadoAlterar'><input type='hidden' name='pagina' value='estados'/><td width='70%'><center><input type='text' name='nome' value='" + lista.get(i).getNome() + "'/></center></td>");
                            out.println("<td width='20%'><center><input type='text' name='sigla' value='" + lista.get(i).getSigla() + "' /></center></td>");
                            out.println("<td><center><input type='submit' value='Alterar' name='excluir'/><input type='hidden' name='id' value='" + lista.get(i).getId() + "' /></center></td></form>");
                            out.println("<form name='listaEstadosExcluir' action='../EstadoExcluir'><input type='hidden' name='pagina' value='estados'/><td><center><input type='submit' value='Excluir' name='excluir'/><input type='hidden' name='id' value='" + lista.get(i).getId() + "' /></center></td></form>");
                            out.println("<tr>");
                        } ;
                    %>
                </table>
            </center>
                
    </div>    


</body>
</html>


