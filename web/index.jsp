<%-- 
    Document   : index
    Created on : Sep 5, 2022, 1:32:39 PM
    Author     : Seba
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet" />
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>

        <link rel="stylesheet" href="./css/index.css">

        <title>| Ole Manolo</title>
    </head>

    <body>
        <div class="container-fluid" style="height: 100%;">
            <!-- Titulo -->
            <div class="row">
                <div class="mt-3">
                    <iframe id="titleBar" name="titleBar" class="titlebar-iframe" src="jsp/titleBar.jsp" frameborder="0"></iframe>
                </div>

            </div>

            <!-- Barra de navegacion-->

            <div class="row mb-3">
                <div class="col-sm-2"></div>
                <div class="col-lg-8">
                    <div class="d-flex justify-content-between">
                        <div class="btn-group">
                            <a href="ServletController?tipoNoticia=todo" target="newsFeed" 
                               class="btn btn-light">
                                <h6>TODO</h6></a>
                            <a href="ServletController?tipoNoticia=politica" target="newsFeed" 
                               class="btn btn-light">
                                <h6>POLÍTICA</h6></a>
                            <a href="ServletController?tipoNoticia=deportes" target="newsFeed" 
                               class="btn btn-light">
                                <h6>DEPORTES</h6></a>
                            <a href="ServletController?tipoNoticia=economia" target="newsFeed" 
                               class="btn btn-light">
                                <h6>ECONOMÍA</h6></a>
                            <a href="ServletController?tipoNoticia=mujer" target="newsFeed" 
                               class="btn btn-light">
                                <h6>MUJER</h6></a>
                            <a href="ServletController?tipoNoticia=noticias" target="newsFeed" 
                               class="btn btn-light">
                                <h6>NOTICIAS</h6></a>
                        </div>

                        <form class="d-flex">
                            <input class="form-control me-2" type="text" placeholder="Buscar">
                            <button class="btn btn-dark" type="button">
                                <i class="bi bi-search"></i>
                            </button>
                        </form>
                    </div>
                </div>    
                <div class="col-sm-2"></div>
            </div>  

            <!-- Feed de noticias -->
            <iframe id="newsFeed" name="newsFeed" style="width: 100%; height: 100%;"></iframe>

        </div>



    </div>
</body>

</html>
