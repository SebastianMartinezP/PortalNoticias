<%-- 
    Document   : Registro
    Created on : 17-09-2022, 16:43:29
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
        <title>Registro</title>
    </head>
    <body >   
        <div class="row newsfeed-iframe">           
                <div class="my-3">       
                        <form action="ServletController?site=index&action=GuardarUsuario" method="POST" target="newsFeed" style="position:absolute;top:30px;left:600px;" >
                            <h1>Nuevo Usuario</h1>
                            <div class="mt-2 mb-2">
                                <label for="txtnicknamenu" class="form-label">Ingresa un nickname: </label>
                                <input type="text" name="txtnicknamenu" id="txtnicknamenu" class="form-control">
                            </div>
                            <div class="mt-2 mb-2">
                                <label for="txtpasswordnu" class="form-label" >Crea una contraseña: </label>
                                <input type="password" name="txtpasswordnu" id="txtpasswordnu" class="form-control">
                            </div>

                            <div class="mt-2 mb-2" style="display:flex">           
                               <input type="reset" class="btn btn-outline-dark form-control" value="Limpiar" name="btnLimpiar" id="btnLimpiar">
                               <button class="btn btn-outline-success form-control" type="submit" id="action" name="action" value="search">Guardar    
                               </button> 
                            </div>
                             <div class="mt-2 mb-2" >
                            </div>
                        </form>   
            </div>    
        </div>
</body>
</html>
