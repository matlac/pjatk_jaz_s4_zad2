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
	<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">            
            <a class="navbar-brand" href="/">System autoryzacji</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="/">Strona główna</a></li>
              <li><a href="/premium">Strona premium</a></li>              
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="/users_list">Lista użytkowników</a></li>
              <li><a href="/user_premiumr">Ustaw premium</a></li>
              <li><a href="/user_profile">Twój profil</a></li> 
              <li><a href="/logout">Wyloguj</a></li>
            </ul>
          </div>
        </div>
     </nav>

    <div class="row">
        <div class="col-md-6 col-md-offset-3">        		
                <table class="table table-bordered table-hover">
                    <thead><tr class="bg-success">
                        <th>Id</th>
                        <th>Login</th>
                        <th>Email</th>
                        <th>Premium</th>
                    </tr></thead><tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.getId()}</td>
                            <td>${user.getLogin()}</td>
                            <td>${user.getEmail()}</td>
                            <td>${user.getPremium()}</td>                        	
                        </tr>
                    </c:forEach></tbody>
                </table>                
        </div>
    </div>
</div>
</body>
</html>