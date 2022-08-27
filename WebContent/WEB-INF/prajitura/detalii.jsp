<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ro">
<head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Detalii Prajitura</title>
     	<link rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/creative/assets/img/icons/prajitura.jpg" />
        <link href="${pageContext.request.contextPath}/creative/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/style-forms/style.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="coffee-guzu">
<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container">
               <a href="${pageContext.request.contextPath}/prajitura/lista.htm">
               <i class="fas fa-4x fa-arrow-left text-primary mb-4"></i>
               </a>
            </div>
        </nav>
<section>
 <div class="container h-100 text-guzu">
 <br><br><br><br><br>
<h1>Detalii Prajitura</h1>
<table class="table">
<tr><td>Id:</td><td><c:out value="${model.prajitura.id}"/></td></tr><br/>
<tr><td>Nume:</td><td><c:out value="${model.prajitura.nume}"/></td></tr><br/>
<tr><td>Descriere:</td><td><c:out value="${model.prajitura.descriere}"/></td></tr><br/>
<tr><td>Pret:</td><td><c:out value="${model.prajitura.pret}"/></td></tr><br/>
</table>
<br>
<a class="btn btn-primary btn-xs js-scroll-trigger" href="<c:url value="/prajitura/edit.htm?id=${model.prajitura.id}"/>">Editare</a>
<a class="btn btn-primary btn-xs js-scroll-trigger" href="<c:url value="/prajitura/delete.htm?id=${model.prajitura.id}"/>">Delete</a>

</div>
</section>
</body>
</html>