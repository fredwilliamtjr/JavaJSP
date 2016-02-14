<%-- 
    Document   : corpo
    Created on : 06/11/2015, 19:15:30
    Author     : fredw
--%>

<%@page import="Modelo.ModeloCidades"%>
<%@page import="Controle.ControleCidades"%>
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
        <title>Cadastro de Cidades</title>
        <link rel="stylesheet" href="../estilo.css"
    </head>
    <body id=<%=application.getAttribute("cor").toString()%>>
    <center><h1>Cadastro de cidades</h1></center>
    <div id="salvar">
        <form name="salvarcidade" action="../CidadeSalvar"><input type="hidden" name="pagina" value="cidades" />
            <h3>Nome: <input type="text" name="nome" value="" /></h3>
            <h3>Estado: <select name="selecaoestado">
                <%ControleEstados estados = new ControleEstados();
                    List<ModeloEstados> listaCombo = estados.listarEstadosNome();
                    for (int i = 0; i < listaCombo.size(); i++) {
                        out.println("<option>"+ listaCombo.get(i).getNome() +"</option>");
                    };
                %></select></h3>
            <input type="submit" value="Salvar" name="btnSalvar" />
        </form>
    </div>
    <div id="lista">

        <center>
            <table border="1">
                <tr>

                    <td><center>Cidade</center></td>
                <td><center>Estado</center></td>

                </tr>

                <%  
                    ControleCidades cidades = new ControleCidades();
                    List<ModeloCidades> lista = cidades.listarCidadesPorNome();
                    for (int i = 0; i < lista.size(); i++) {
                        ModeloEstados estado = new ModeloEstados();
                        estado.setId(lista.get(i).getId_estado());
                        out.println("<tr>");
                        out.println("<form name='listaCidadesAlterar' action='../CidadeAlterar'><input type='hidden' name='pagina' value='cidades'/><td width='70%'><center><input type='text' name='nome' value='" + lista.get(i).getNome() + "'/></center></td>");
                        out.println("<td width='20%'><center>" + estados.recebeIdDevolveNomeEstado(estado).getNome() + "</center></td>");
                        out.println("<td><center><input type='submit' value='Alterar' name='excluir'/><input type='hidden' name='id' value='" + lista.get(i).getId() + "' /></center></td></form>");
                        out.println("<form name='listaCidadesExcluir' action='../CidadeExcluir'><input type='hidden' name='pagina' value='cidades'/><td><center><input type='submit' value='Excluir' name='excluir'/><input type='hidden' name='id' value='" + lista.get(i).getId() + "' /></center></td></form>");
                        out.println("<tr>");
                    };
                %>
            </table>
        </center>

    </div>    


</body>
</html>


