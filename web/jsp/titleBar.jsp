<%-- 
    Document   : titleBar
    Created on : Sep 8, 2022, 2:21:04 PM
    Author     : Seba
--%>

<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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

    <link rel="stylesheet" href="../css/index.css">
    <title>titlebar</title>
    
    <%
            
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String day = now.getDayOfWeek().getDisplayName(TextStyle.FULL, df.getLocale());
        int dayDate = now.getDayOfMonth();
        String month = now.getMonth().getDisplayName(TextStyle.FULL, df.getLocale());
        int year = now.getYear();

    %>
    
</head>
<body>
    <div class="d-flex justify-content-left px-4">
        <i class="bi bi-calendar"></i>
        <h6 class="mx-2"><%= day %> <%= dayDate %> de <%= month %>, <%=year%>.</h6>
    </div>
    <div class="text-center">
        <h2>OLE MANOLO</h2>
        <h5>Portal de noticias Online</h5>
        <hr class="hr hr-blurry" />
    </div>
</body>
</html>
