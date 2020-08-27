<%-- 
    Document   : index
    Created on : 16/08/2020, 20:27:01
    Author     : ana
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body style="background-color: #EEF">
        <div align="center">
            <header><img src="tads.png"><br>BEIBE<br>Beauty Embuste Indústria de Beleza e Estética</header>
                <br><br>
                <form method="post" action="LoginServlet">
                    <div class="input-group input-group-sm mb-3" style="width: 250px">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroup-sizing-sm">Login</span>
                        </div>
                        <input type="text" name="login" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                    </div>
                    <div class="input-group input-group-sm mb-3" style="width: 250px">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroup-sizing-sm">Senha</span>
                        </div>
                        <input type="password" name="senha" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                    </div>
                    <br>
                    <input type="submit" name="enviar" value="Login" class="btn btn-light"></br></br>
                </form>
                <br>
                <form method="post" action="usuarioNovo.jsp">
                    Ainda não está cadastrado?
                    <br>
                    <input type="submit" name="enviar" value="Cadastre-se" class="btn btn-light"></br></br>
                </form>
                <div style="bottom: 40px; width: 30%; position: absolute; margin-left: 35%">
                <%
                    if (request.getAttribute("msg") != null) {
                %>
                <div class="alert alert-danger" role="alert">
                    <%
                            out.println(request.getAttribute("msg"));
                        }
                    %>
                </div>
            </div>
        </div>
        <div class="footer-copyright text-center py-3" style="position: absolute; bottom: 0; width: 100%">
            Em caso de problemas contactar o administrador:
            <jsp:useBean id="configuracao" class="beans.ConfigBean" scope="application" />
            <jsp:getProperty name="configuracao" property="email" />
        </div>
    </body>
</html>
