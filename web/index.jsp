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
        <div class="container-fluid">
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
                    <div class="d-flex justify-content-center">
                        <div class="vr mx-2" style="height: 30px;"></div>

                        <div class="btn-group d-flex shadow-0">
                            <form class="d-flex" action="ServletController?site=index&action=searchNoticiaByTitulo" method="POST" target="newsFeed">
                                <input id="txtSearch" name="txtSearch" class="form-control me-2" type="text" placeholder="Buscar Noticias" style="width: 140px;">
                                <button class="btn btn-dark me-2" type="submit" id="action" name="action" value="search">
                                    <i class="bi bi-search"></i>
                                </button>
                                <a href="ServletController?site=index&action=listOldestNews" target="newsFeed"
                               class="btn btn-dark shadow-0">
                                <i class="bi bi-arrow-return-left"></i>
                            </a>
                            </form>



                            <div class="vr mx-2" style="height: 30px;"></div>

                        </div>

                        <form class="d-flex" action="ServletController?site=index&action=searchNoticiaByDate" method="POST" target="newsFeed">
                            <input id="txtDay" name="txtDay" class="form-control  me-2" type="text" placeholder="DD" style="width: 55px;">
                            <input id="txtMonth" name="txtMonth" class="form-control me-2" type="text" placeholder="MM" style="width: 55px;">
                            <input id="txtYear" name="txtYear" class="form-control  me-2" type="text" placeholder="AAAA" style="width: 80px;">
                            <button class="btn btn-dark  shadow-0" type="submit" id="action" name="action" value="search">
                                <i class="bi bi-calendar"></i>
                            </button>
                        </form>
                        
                        <div class="vr mx-2" style="height: 30px;"></div>
                    </div>
                </div>

                <div class="d-flex justify-content-center">
                    <div class="btn-group shadow-0">
                        <a href="ServletController?site=index&action=getNoticiaByTipoNoticia&tipoNoticia=todo" target="newsFeed" 
                           class="btn btn-light shadow-0">
                            <h6>TODO</h6></a>
                        <a href="ServletController?site=index&action=getNoticiaByTipoNoticia&tipoNoticia=politica" target="newsFeed" 
                           class="btn btn-light shadow-0">
                            <h6>POLÍTICA</h6></a>
                        <a href="ServletController?site=index&action=getNoticiaByTipoNoticia&tipoNoticia=deportes" target="newsFeed" 
                           class="btn btn-light shadow-0">
                            <h6>DEPORTES</h6></a>
                        <a href="ServletController?site=index&action=getNoticiaByTipoNoticia&tipoNoticia=economia" target="newsFeed" 
                           class="btn btn-light shadow-0">
                            <h6>ECONOMÍA</h6></a>
                        <a href="ServletController?site=index&action=getNoticiaByTipoNoticia&tipoNoticia=mujer" target="newsFeed" 
                           class="btn btn-light shadow-0">
                            <h6>MUJER</h6></a>
                        <a href="ServletController?site=index&action=getNoticiaByTipoNoticia&tipoNoticia=noticias" target="newsFeed" 
                           class="btn btn-light shadow-0">
                            <h6>NOTICIAS</h6></a>
                    </div>



                </div>
            </div>    
            <div class="col-sm-2"></div>
        </div>  

        <!-- Feed de noticias -->
        <iframe class="newsfeed-iframe" id="newsFeed" name="newsFeed"></iframe>

    </div>



</div>
</body>

</html>
