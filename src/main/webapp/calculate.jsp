<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                <table class="table table-bordered table-hover">
                    <thead><tr class="bg-success">
                        <th>Nr raty</th>
                        <th>Część kapitałowa</th>
                        <th>Odsetki</th>
                        <th>Rata</th>
                    </tr></thead><tbody>
                    <c:forEach items="${calculate}" var="rate">
                        <tr>
                            <td>${rate.getRate_number()}</td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${rate.getRate_amount()/100}" /></td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${rate.getRate_interest()/100}" /></td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${rate.getRate_sum()/100}" /></td>
                        </tr>
                    </c:forEach></tbody>
                </table>
                <br/>
                <a href="/calculate?action=download_pdf" target="_blank"><button class="btn btn-primary pull-right">Pobierz PDF ></button></a>
        </div>
    </div>
</div>
</body>
</html>