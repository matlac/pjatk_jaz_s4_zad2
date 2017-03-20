<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <title>Kalkulator raty kredytu</title>
</head>
<body>
<div class="container" style="padding: 30px;">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="calculate" method="post">
                <c:if test="${sessionScope.FormError}">
                    <div class="alert alert-danger">Podaj poprawne dane</div>
                </c:if>
                <% session.removeAttribute("FormError"); %>
                <table class="table">
                    <tr>
                        <td width="40%"><label>Kwota kredytu:</label></td>
                        <td><input type="number" class="form-control" min="0" name="amount"></td>
                    </tr>
                    <tr>
                        <td><label>Ilość rat:</label></td>
                        <td><input type="number" class="form-control" min="0" name="rates_count"></td>
                    </tr>
                    <tr>
                        <td><label>Oprocentowanie:</label></td>
                        <td><input type="number" class="form-control" min="0" step="0.01" name="percent"></td>
                    </tr>
                    <%--<!-- Nie wiem do czego to ma służyć -->--%>
                    <%--<tr>--%>
                        <%--<td><label>Opłata stała:</label></td>--%>
                        <%--<td><input type="number" class="form-control" name="const_rate_amount"></td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td><label>Rodzaj rat:</label></td>
                        <td>
                            <div class="form-check"><input type="radio" class="form-check-input" name="rates_type" value="decrease"> Malejące</div>
                            <div class="form-check"><input type="radio" class="form-check-input" name="rates_type" value="equal"> Stałe</div>
                        </td>
                    </tr>
                </table>
                <br/>
                <input type="submit" class="btn btn-primary pull-right" value="Harmonogram spłat">
            </form>
        </div>
    </div>
</div>
</body>
</html>