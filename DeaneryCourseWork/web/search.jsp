<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Пошук груп</title>
    </head>
    <body>
        <% request.getSession().setAttribute("action","search"); %>
        <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        <h1>Введіть інформацію для пошуку</h1>
        <form action="FrontController" method="POST">
            <input type="radio" name="search"  value="name" required  > За назвою <br>
            <input type="radio" name="search"  value="surname" required> За прізвищем студента <br>
          <label for="text">Текст для пошуку</label>
          <input type="text" name="text" placeholder="Введіть інформацію" required> 
          <input type="submit" name="button" value="Знайти">
        </form>
 
    </body>
</html>
