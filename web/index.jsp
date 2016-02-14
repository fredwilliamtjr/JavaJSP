<%-- 
    Document   : index
    Created on : 06/11/2015, 14:06:46
    Author     : fredw
--%>

<%@page import="java.sql.Connection"%>
<%@page import="Controle.ControleConfiguracoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="estilo.css"
    </head>
    <%application.setAttribute("cor",new ControleConfiguracoes().getConfiguracoes().getCor());%>
    <body id=<%=application.getAttribute("cor").toString()%>>
    <center><h1>Bem vindo!!!<br>Cadastros - JSP!!!</h1></center>
    <div id="login">

        <form id="login" action="./Login">
            <h3>Login: <input type="text" name="login" value="" /></h3>
            <h3>Senha: <input type="password" name="senha" value="" /></h3>

            <input type="submit" value="Login" name="BtnLogin"/>

        </form>

    </div>

</body>
</html>
