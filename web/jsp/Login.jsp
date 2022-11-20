<%-- 
    Document   : Registro
    Created on : 16-09-2022, 20:14:12
    Author     : Casa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>      
    <center>
        <h1>Inicio de Sesión</h1>
        <div class="w-50">

            <form action="ServletController?site=index&action=Login" method="POST" target="newsFeed">
                <div>
                    <h4 id="message">${message}</h4>    
                <div/>
                <div class="mt-2 mb-2">
                    <label for="txtnickname" class="form-label">Nickname: </label>
                    <input type="text" name="txtnickname" id="txtnickname" class="form-control">
                </div>
                <div class="mt-2 mb-2">
                    <label for="txtpassword" class="form-label">Password: </label>
                    <input type="password" name="txtpassword" id="txtpassword" class="form-control">
                </div>

                <div class="mt-2 mb-2" style="display:flex">
                    <button class="btn btn-outline-success form-control" type="submit" id="action" name="action" value="search">Entrar  
                    </button>                   
                    <input type="reset" class="btn btn-outline-dark form-control" value="Limpiar" name="btnLimpiar" id="btnLimpiar">
                </div>
                <div class="mt-2 mb-2" >
                    <label for="txtpassword" class="form-label">¿No tienes cuenta? </label>
                    <a href="ServletController?site=index&action=nuevoRegistro" target="newsFeed" class="btn btn-outline-success form-control">Registrate</a>
                </div>


            </form>
        </div>
    </center>
</body>
</html>
