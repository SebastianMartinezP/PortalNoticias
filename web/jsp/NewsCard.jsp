<%-- 
    Document   : NewsCard
    Created on : Sep 7, 2022, 5:44:27 PM
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

    <link rel="stylesheet" href="/css/index.css">
    
    <title>news_card</title>
</head>
<body>
    <div class="card ">
        <c:forEach var="n" items="${noticias}">
            <div class="bg-image hover-overlay">
                <div class="bg-image rounded-6">
                    <img src="/img/1662129246-covid-viernes.jpg" class="w-100" />
                    <!-- Mask -->
                    <div class="mask" style="background-color: rgba(0, 0, 0, 0.6)">
                        <div class="card-img-overlay">
                            <h5 class="card-title text-white user-select-none"> ${n.getIdNoticia} </h5>
                            <p class="card-text text-white user-select-none"> ${n.getFechaEmision()}</p>
                        </div>
                    </div>
                </div>

            </div>

            <div class="card-body">
                <h3 class="card-title">${n.getTitulo()}</h3>
            </div>

            <div class="card-footer">
                <p class="card-text">${n.getSubtitulo()}</p>
                <div class="d-flex justify-content-between my-2">
                    <div>
                        <i class="bi bi-chat-square-dots mx-2"></i>
                        <small class="text-muted user-select-none">341 comentarios</small>
                    </div>
                    <a href="#!" class="btn btn-dark ripple">Leer más</a>
                </div>

        </div>
        </c:forEach>
    </div>
</body>
</html>
