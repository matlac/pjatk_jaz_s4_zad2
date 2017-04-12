<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <title>System autoryzacji</title>
</head>
<body>
<div class="container" style="padding: 30px;">
	<jsp:include page="menu.jsp"></jsp:include>

    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        		<h1>Profil użytkownika: ${sessionScope.LoggedUser.getLogin()}</h1>
            Email: ${sessionScope.LoggedUser.getEmail()}<br/>
            Premium: <c:choose>
            <c:when test="${sessionScope.LoggedRole==0}">
                nie
            </c:when>
            <c:when test="${sessionScope.LoggedRole==1}">
                tak
            </c:when>
            <c:when test="${sessionScope.LoggedRole==2}">
                admin
            </c:when>
        </c:choose>
        </div>
    </div>
</div>
</body>
</html>