<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <title>System autoryzacji</title>
</head>
<body>
<div class="container" style="padding: 30px;">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="register" method="post">
                <c:if test="${sessionScope.FormError}">
                    <div class="alert alert-danger">Podaj poprawne dane rejestracji</div>
                </c:if>
                <% session.removeAttribute("FormError"); %>
                <table class="table">
                    <tr>
                        <td width="40%"><label>Login:</label></td>
                        <td><input type="test" class="form-control" name="login"></td>
                    </tr>
                    <tr>
                        <td><label>Hasło:</label></td>
                        <td><input type="password" class="form-control" name="password"></td>
                    </tr>
                    <tr>
                        <td><label>Powtórz hasło:</label></td>
                        <td><input type="password" class="form-control" name="password2"></td>
                    </tr>                   
                    <tr>
                        <td><label>Email:</label></td>
                        <td>
                        	<input type="email" class="form-control" name="email">
                        </td>                    
                    </tr>
                </table>
                <br/>
                <input type="submit" class="btn btn-primary pull-right" value="Zarejestruj się">
            </form>
        </div>
    </div>
</div>
</body>
</html>