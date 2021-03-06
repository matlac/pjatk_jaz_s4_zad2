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
        <div class="col-md-8 col-md-offset-2 text-center">
                <c:if test="${sessionScope.NoRights}">
                    <div class="alert alert-danger">Brak uprawnień</div>
                </c:if>
                <% session.removeAttribute("NoRights"); %>
        		<h1>System autoryzacji</h1>       		
                <img height="160" style="margin-top: 40px;" src="img/logo.png">
        </div>
    </div>
</div>
</body>
</html>