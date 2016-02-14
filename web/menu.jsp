<%-- 
    Document   : PaginaPrincipal
    Created on : 06/11/2015, 15:41:11
    Author     : fredw
--%>

<%@page import="Controle.ControleConfiguracoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
       <link rel="stylesheet" href="estilo.css"
    </head>
    <body id=<%=application.getAttribute("cor").toString()%>>
    <center>
        <table border="0">
            <thead>
                <tr>
                    <th>
                        <form id="cadastro_estados" action="cadastros/estados.jsp" target="corpo">
                            <input type="submit" value="Cadastro de Estados" name="Cadastro_Estados" />
                        </form>
                    </th>
                    <th>
                        <form id="cadastro_cidades" action="cadastros/cidades.jsp" target="corpo">
                            <input type="submit" value="Cadastro de Cidades" name="Cadastro_Cidades" />
                        </form>
                    </th>
                    <th>
                        <form id="logout" action="index.jsp" target="_top">
                            <input type="submit" value="LogOut" name="LogOut" />
                        </form>
                    </th>
                </tr>
            </thead>    
        </table>
    </center>
</body>
</html>
