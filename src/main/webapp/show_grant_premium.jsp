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
    <div class="col-md-6 col-md-offset-3 text-center">
      <form action="/do_grant_premium" method="post">
        <table class="table">
          <tr>
            <td width="40%"><label>Użytkownik:</label></td>
            <td class="text-left"><select name="user_id" style="width: 80%">
              <option value="none">-- wybierz --</option>
              <c:forEach items="${users}" var="user">
                <option value="${user.getId()}">${user.getLogin()}</option>
              </c:forEach>
            </select></td>
          </tr>
          <tr>
            <td></td>
            <td class="text-left">
              <input type="radio" name="action" value="add" checked> Ustaw premium<br/>
              <input type="radio" name="action" value="remove"> Usuń premium<br/>
            </td>
          </tr>
        </table>
        <br/>
        <input type="submit" class="btn btn-primary pull-right" value="Zapisz">
      </form>
    </div>
  </div>
</div>
</body>
</html>