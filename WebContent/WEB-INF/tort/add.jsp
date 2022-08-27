<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ro">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Adaugare Tort</title>
     	<link rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/creative/assets/img/icons/tort.jpg" />
        <link href="${pageContext.request.contextPath}/creative/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/style-forms/style.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="coffee-guzu">
<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container">
               <a href="${pageContext.request.contextPath}/tort/lista.htm">
               <i class="fas fa-4x fa-arrow-left text-primary mb-4"></i>
               </a>
            </div>
        </nav>
<section>
 <div class="container h-100 text-guzu font-size-guzu">
 <br><br><br><br><br>
<h1>Adaugare Tort</h1>
<form:form action="${pageContext.request.contextPath}/tort/add-save.htm" method="post" commandName="tortForm">
Nume: <form:input path="nume"/><br/>
Descriere: <form:input path="descriere"/><br/>
Pret: <form:input path="pret"/><br/>
Imagine: <form:input path="imagine"/><br/>
<input type="submit" value="Salveaza"/></br/>
</form:form>
</div>
</section>
</body>
</html>