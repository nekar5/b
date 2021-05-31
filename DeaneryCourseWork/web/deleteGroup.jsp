<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Видалити групу</title>
    </head>
    <body>
        <% request.getSession().setAttribute("action","deletegroup"); %>
        <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        <h1>Додайте інформацію про групу</h1>
        <form action="FrontController" method="POST">
          <label for="name">Назва групи</label>
          <input type="text" name="name" placeholder="Введіть назву" required> <br>
          <input type="submit" name="button" value="Видалити">
        </form>
    </body>
</html>
