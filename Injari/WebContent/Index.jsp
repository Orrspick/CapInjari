<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
<meta charset="UTF-8">
<title>인자리 - Injari</title>
</head>
<body>
<div id="header">
<jsp:include page="include/header.jsp"/>
</div>
<div style="margin-top: 50px" id="main">
<c:set var="contentPage" value="${param.contentPage}" />
<c:choose>
<c:when test="${contentPage==null}">
	<jsp:include page="Main.jsp"/>
</c:when>
<c:otherwise>
<jsp:include page="${contentPage}"/>
</c:otherwise>
</c:choose>
</div>
<div id="footer">
<jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>