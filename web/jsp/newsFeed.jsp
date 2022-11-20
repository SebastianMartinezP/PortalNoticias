<%-- Document : newsFeed Created on : Sep 8, 2022, 3:09:33 PM Author : Seba --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
              rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
              rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet" />
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>

        <link rel="stylesheet" href="/css/index.css">

        <title>newsFeed</title>
    </head>

    <body>
        <div class="row newsfeed-iframe">
            <div class="col-lg-12 bg-light">
                <div class="my-3">
                    <div>
                        <h1 id="message">${message}</h1>    
                        <div/>
                        <div class="d-flex flex-wrap justify-content-evenly">
                            <c:forEach var="n" items="${noticias}">
                                <div class="card card-iframe">
                                    <div class="bg-image hover-overlay">
                                        <div class="bg-image rounded-6">  
                                            <img src="img/placeholder.jpg" class="w-35" />
                                            <!-- Mask -->
                                            <div class="mask" style="background-color: rgba(0, 0, 0, 0.6)">
                                                <div class="card-img-overlay">
                                                    <h5 class="card-title text-white user-select-none">
                                                        ${n.getIdNoticia()} </h5>
                                                    <p class="card-text text-white user-select-none">
                                                        ${n.getFechaEmision()}</p>
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
                                            <a href="#!"
                                               class="btn btn-dark ripple" 
                                               data-mdb-toggle="modal" data-mdb-target="#exampleModal_${n.getIdNoticia()}">
                                                Leer más
                                            </a>
                                        </div>

                                    </div>

                                    <div class="modal fade" id="exampleModal_${n.getIdNoticia()}" tabindex="-1" 
                                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-scrollable modal-xl"
                                             style="max-width: 1900px;">

                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <div class="d-flex">
                                                        <a 
                                                            class="btn btn-danger" 
                                                            href="ServletController?site=newsFeed&action=downloadPdfById&idNoticia=${n.getIdNoticia()}" target="newsFeed">
                                                            <i class="bi bi-download" style="width: 25px; height: 25px;"></i> 
                                                            PDF 
                                                        </a>
                                                    </div>

                                                    <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="col-lg-1 bg-light">
                                                        </div>

                                                        <div class="col-lg-10 bg-light">
                                                            <div class="text-paragraph">
                                                                <h5>${n.getTitulo()}</h5>
                                                                <h4>${n.getSubtitulo()}</h4>
                                                                <p>${n.getCuerpo()}</p>
                                                            </div>

                                                            <div>
                                                                <!-- Carousel wrapper -->
                                                                <div id="carouselBasicExample_${n.getIdNoticia()}"
                                                                     class="carousel slide carousel-fade"
                                                                     data-mdb-ride="carousel">
                                                                    <!-- Indicators -->
                                                                    <div class="carousel-indicators">
                                                                        <c:forEach var="img" items="${n.imagenes}">
                                                                            <c:choose>
                                                                                <c:when test="${n.imagenes.indexOf(img) == 0}">
                                                                                    <button type="button"
                                                                                            data-mdb-target="#carouselBasicExample_${n.getIdNoticia()}"
                                                                                            data-mdb-slide-to="${n.imagenes.indexOf(img)}" class="active"
                                                                                            aria-current="true"
                                                                                            aria-label="Slide ${n.imagenes.indexOf(img) + 1}"></button>
                                                                                </c:when>

                                                                                <c:otherwise>
                                                                                    <button type="button"
                                                                                            data-mdb-target="#carouselBasicExample_${n.getIdNoticia()}"
                                                                                            data-mdb-slide-to="${n.imagenes.indexOf(img)}"
                                                                                            aria-current="true"
                                                                                            aria-label="Slide ${n.imagenes.indexOf(img) + 1}"></button>
                                                                                </c:otherwise>

                                                                            </c:choose>
                                                                        </c:forEach>
                                                                    </div>

                                                                    <!-- Inner -->
                                                                    <div class="carousel-inner" id="imagens" >

                                                                        <c:forEach var="img" items="${n.imagenes}">
                                                                            <c:choose>
                                                                                <c:when test="${n.imagenes.indexOf(img) == 0}">
                                                                                    <div class="carousel-item active">
                                                                                        <img src="data:image/jpg;base64,${img.getBase64Imagen()}" height="200"
                                                                                             class="d-block w-100"/>
                                                                                        <div class="carousel-caption d-none d-md-block">
                                                                                            <h5>${n.getAutor()}</h5>
                                                                                            <p>${n.getSubtitulo()}</p>
                                                                                        </div>
                                                                                    </div>
                                                                                </c:when>

                                                                                <c:otherwise>
                                                                                    <!-- Single item -->
                                                                                    <div class="carousel-item">
                                                                                        <img src="data:image/jpg;base64,${img.getBase64Imagen()}" height="200"
                                                                                             class="d-block w-100"/>
                                                                                        <div class="carousel-caption d-none d-md-block">
                                                                                            <h5>${n.getAutor()}</h5>
                                                                                            <p>${n.getSubtitulo()}</p>
                                                                                        </div>
                                                                                    </div>
                                                                                </c:otherwise>

                                                                            </c:choose>
                                                                        </c:forEach>
                                                                    </div>
                                                                    <!-- Inner -->      

                                                                    <!-- Controls -->
                                                                    <button class="carousel-control-prev"
                                                                            type="button"
                                                                            data-mdb-target="#carouselBasicExample_${n.getIdNoticia()}"
                                                                            data-mdb-slide="prev">
                                                                        <span class="carousel-control-prev-icon"
                                                                              aria-hidden="true"></span>
                                                                        <span
                                                                            class="visually-hidden">Previous</span>
                                                                    </button>
                                                                    <button class="carousel-control-next"
                                                                            type="button"
                                                                            data-mdb-target="#carouselBasicExample_${n.getIdNoticia()}"
                                                                            data-mdb-slide="next">
                                                                        <span class="carousel-control-next-icon"
                                                                              aria-hidden="true"></span>
                                                                        <span class="visually-hidden">Next</span>
                                                                    </button>
                                                                </div>
                                                                <!-- Carousel wrapper -->
                                                            </div>


                                                        </div>




                                                        <!-- Caja de comentarios -->

                                                        <div class="card m-3" style="max-width: 900px;">
                                                            <div class="card-header">
                                                                <h3 class="me-3">COMENTARIOS</h3>
                                                            </div>
                                                            <div class="card-body">


                                                                <!-- Comentarios -->
                                                                <div class="d-flex justify-content-center mx-2 my-2">
                                                                    <form class="d-flex" action="ServletController?site=newsFeed&action=SaveComment" method="POST" target="newsFeed">
                                                                        <input  id="idNoticia" name="idNoticia" type="hidden" value="${n.getIdNoticia()}">
                                                                        <input  id="inputComment" name="inputComment" type="text" value="">
                                                                        <button class="btn btn-success form-control mx-2" type="submit" id="saveComment" name="saveComment" value="send">Enviar    
                                                                    </form>
                                                                </div>
                                                                        
                                                                <div class="d-flex justify-content-between">
                                                                    <ul class="list-group list-group-light">
                                                                        <c:forEach var="c" items="${n.comentarios}">
                                                                            <c:choose>
                                                                                <c:when test="${c.getIsEnabled() == true}">
                                                                                    <li class="list-group-item mx-2" style="max-width: 800px;">
                                                                                        <div class="card">
                                                                                            <div class="card-body">
                                                                                                <div class="d-flex">
                                                                                                    <h4 class="me-3">${c.getUsuario().getNickname()}</h4>

                                                                                                </div>
                                                                                                <div class="d-flex text-wrap">
                                                                                                    <p>${c.getContenido()}</p>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="card-footer text-muted">
                                                                                                <a class="btn btn-dark shadow-0 btn-rounded" href="#!" target="newsFeed">
                                                                                                    <i class="bi bi-flag-fill"></i></i>
                                                                                                </a>
                                                                                            </div>
                                                                                        </div>


                                                                                    </li>
                                                                                </c:when>

                                                                                <c:otherwise>
                                                                                    <li class="list-group-item mx-3" style="max-width: 800px;">
                                                                                        <div class="card">
                                                                                            <div class="card-body">
                                                                                                <div class="d-flex">
                                                                                                    <h4 class="me-3">${c.getUsuario().getNickname()} <span class="badge badge-danger">Banned</span></h4>

                                                                                                </div>
                                                                                                <div class="placeholder-glow">
                                                                                                    <p>
                                                                                                        <span class="placeholder col-7"></span>
                                                                                                        <span class="placeholder col-4"></span>
                                                                                                        <span class="placeholder col-4"></span>
                                                                                                        <span class="placeholder col-6"></span>
                                                                                                        <span class="placeholder col-8"></span>
                                                                                                    </p>
                                                                                                </div>

                                                                                            </div>
                                                                                            <div class="card-footer text-muted">
                                                                                                <a class="btn btn-dark shadow-0 btn-rounded" href="#!" target="newsFeed">
                                                                                                    <i class="bi bi-flag-fill"></i></i>
                                                                                                </a>
                                                                                            </div>
                                                                                        </div>
                                                                                    </li>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:forEach>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-lg-1 bg-light">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
    </body>

</html>