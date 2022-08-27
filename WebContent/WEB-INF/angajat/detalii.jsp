<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii Angajat</title>
</head>
<body>
<h1>Detalii Angajat</h1>
Id:<c:out value="${model.angajat.id}"/><br/>
Nume:<c:out value="${model.angajat.nume}"/><br/>
Prenume:<c:out value="${model.angajat.prenume}"/><br/>
Adresa:<c:out value="${model.angajat.adresa}"/><br/>
Telefon:<c:out value="${model.angajat.telefon}"/><br/>
<a href="<c:url value="/angajat/lista.htm"/>">Inapoi la lista</a>

</body>
</html>