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
        <title>Lista Angajati</title>
     	<link rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/creative/assets/img/icons/angajati.jpg" />
        <link href="${pageContext.request.contextPath}/creative/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/style-forms/style.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="coffee-guzu">
 <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container">
               <a href="${pageContext.request.contextPath}">
               <i class="fas fa-4x fa-arrow-left text-primary mb-4"></i>
               </a>
            </div>
        </nav>
            <div class="container h-100">
                <h2 class="text-guzu text-center mt-0"><br>Angajati</h2>
                <hr class="divider my-4" />
                <div class="row">
                
               			 <table class="table">
							<thead>
						    <tr>
						       <td>ID</td>
						       <td>Nume</td>
						       <td>Prenume</td>
						       <td>Adresa</td>
						       <td>Telefon</td>
						       <td></td>
						       <td></td>
						    </tr> 
						    </thead>
						    <tbody>
							<c:forEach var = "angajat" items="${model.angajati}">
						         <tr>
							         <td><c:out value = "${angajat.id}"/></td>
							         <td><c:out value = "${angajat.nume}"/></td>
							         <td><c:out value = "${angajat.prenume}"/></td>
							         <td><c:out value = "${angajat.adresa}"/></td>
							         <td><c:out value = "${angajat.telefon}"/></td>
							         <td><a href="<c:url value="/angajat/edit.htm?id=${angajat.id}"/>">Edit</a>
							         <td><a href="<c:url value="/angajat/delete.htm?id=${angajat.id}"/>">Delete</a>
						         </tr>
						    </c:forEach>
						    </tbody>
							</table>

						    
					</div>
					<br>
					<p align="right">
					<a class="btn btn-primary btn-xl js-scroll-trigger" href="${pageContext.request.contextPath}/angajat/add.htm">Adaugare Angajat</a> </p>
                </div>
                
		
</body>
</html>