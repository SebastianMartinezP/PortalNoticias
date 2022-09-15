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
                                        <a href="#!" class="btn btn-dark ripple" data-mdb-toggle="modal"
                                           data-mdb-target="#exampleModal_${n.getIdNoticia()}" target="newsContent">Leer más ${n.getIdNoticia()}</a>
                                    </div>

                                </div>

                                    <div class="modal fade" id="exampleModal_${n.getIdNoticia()}" tabindex="-1" 
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-scrollable modal-xl"
                                         style="max-width: 1900px;">

                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="btn-close" data-mdb-dismiss="modal"
                                                        aria-label="Close"></button>
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
                                                                    <button type="button"
                                                                            data-mdb-target="#carouselBasicExample"
                                                                            data-mdb-slide-to="0" class="active"
                                                                            aria-current="true"
                                                                            aria-label="Slide 1"></button>
                                                                    <button type="button"
                                                                            data-mdb-target="#carouselBasicExample"
                                                                            data-mdb-slide-to="1"
                                                                            aria-label="Slide 2"></button>
                                                                    <button type="button"
                                                                            data-mdb-target="#carouselBasicExample"
                                                                            data-mdb-slide-to="2"
                                                                            aria-label="Slide 3"></button>
                                                                </div>

                                                                <!-- Inner -->
                                                                <div class="carousel-inner">
                                                                    <!-- Single item -->
                                                                    <div class="carousel-item active">
                                                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(15).webp"
                                                                             class="d-block w-100"
                                                                             alt="Sunset Over the City" />
                                                                        <div
                                                                            class="carousel-caption d-none d-md-block">
                                                                            <h5>First slide label</h5>
                                                                            <p>
                                                                                Nulla vitae elit libero, a
                                                                                pharetra augue
                                                                                mollis
                                                                                interdum.
                                                                            </p>
                                                                        </div>
                                                                    </div>

                                                                    <!-- Single item -->
                                                                    <div class="carousel-item">
                                                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(22).webp"
                                                                             class="d-block w-100"
                                                                             alt="Canyon at Nigh" />
                                                                        <div
                                                                            class="carousel-caption d-none d-md-block">
                                                                            <h5>Second slide label</h5>
                                                                            <p>
                                                                                Lorem ipsum dolor sit amet,
                                                                                consectetur
                                                                                adipiscing
                                                                                elit.
                                                                            </p>
                                                                        </div>
                                                                    </div>

                                                                    <!-- Single item -->
                                                                    <div class="carousel-item">
                                                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(23).webp"
                                                                             class="d-block w-100"
                                                                             alt="Cliff Above a Stormy Sea" />
                                                                        <div
                                                                            class="carousel-caption d-none d-md-block">
                                                                            <h5>Third slide label</h5>
                                                                            <p>
                                                                                Praesent commodo cursus magna,
                                                                                vel
                                                                                scelerisque nisl
                                                                                consectetur.
                                                                            </p>
                                                                        </div>
                                                                    </div>
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


                                                    <div class="col-lg-1 bg-light">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">

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