<%-- 
    Document   : login_error
    Created on : 06/11/2015, 18:30:21
    Author     : fredw
--%>

<%@page import="Controle.ControleConfiguracoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
        <link rel="stylesheet" href="../estilo.css"
    </head>
    <body id=<%=application.getAttribute("cor").toString()%>>
    <center>
        <h1>Erro ao cadastar, alterar ou excluir estado!!!</h1>
        <form name="voltar" action="../cadastros/estados.jsp">
            <input type="submit" value="Voltar" name="BtnVoltar" />
        </form>
    </center>
</body>
</html>
