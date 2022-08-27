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
        <title>Lista Sucuri</title>
     	<link rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/creative/assets/img/icons/tort.jpg" />
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
                <h2 class="text-guzu text-center mt-0"><br>Torturi</h2>
                <hr class="divider my-4" />
                <div class="row">
                
               			<c:forEach var = "tort" items="${model.torturi}">
									 <div class="col-lg-3 col-md-6 text-center">
                       				 <div class="mt-5">
                       				 
                       				 	<a href="<c:url value="/tort/detalii.htm?id=${tort.id}"/>">
                       		 <img height=100 src='${pageContext.request.contextPath}/creative/assets/img/portfolio/torturi/<c:out value = "${tort.imagine}"/>'/>
                    			
                    			<h3 class="h4 mb-2"><c:out value = "${tort.nume}"/></h3> </a>
							     <p class="text-guzu mb-0"><c:out value = "${tort.pret}"/> lei</p>
					       
					      </div>
					      </div> 					        
					    </c:forEach>
						    
					</div>
					<p align="right">
					<a class="btn btn-primary btn-xl js-scroll-trigger" href="${pageContext.request.contextPath}/tort/add.htm">Adaugare Tort</a> </p>
                </div>
                
		
</body>
</html>