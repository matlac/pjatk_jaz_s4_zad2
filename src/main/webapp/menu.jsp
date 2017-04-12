<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default" style="margin-bottom: 40px;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">System autoryzacji</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="/">Strona główna</a></li>
        <li><a href="/premium.jsp">Premium</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <c:choose>
          <c:when test="${sessionScope.LoggedIn==true}">
            <c:if test="${sessionScope.LoggedRole==2}">
              <li><a href="/show_users_list">Lista użytkowników</a></li>
              <li><a href="/show_grant_premium">Ustaw premium</a></li>
            </c:if>
            <li><a href="/show_user_profile">Twój profil</a></li>
            <li><a href="/do_logout">Wyloguj</a></li>
          </c:when>
          <c:otherwise>
            <li><a href="/show_login.jsp">Logowanie</a></li>
            <li><a href="/show_register.jsp">Rejestracja</a></li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>
