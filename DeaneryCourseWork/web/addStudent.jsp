<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Додати студента</title>
    </head>
    <body>
        <% request.getSession().setAttribute("action","addstudent"); %>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <h1>Введіть інформацію про студента</h1>
        <form action="FrontController" method="POST">
        <label for="name">Ім'я студента</label>
        <input type="text" name="name" placeholder="Введіть ім'я студента" required><br> <br>
        <label for="surname">Прізвище студента</label>
        <input type="text" name="surname" placeholder="Введіть прізвище студента" required><br> <br>
        <select name="groupName">
              <c:forEach items="${groups}" var="group">
                  <option value="${group.name}">${group.name}</option>
             </c:forEach>
        </select>
        <br> <br>
        <label for="rating">Середній бал студента</label>
        <input type="number" name="rating" placeholder="Введіть рейтинг студента"  step="0.01" required><br> <br>
        <input type="submit" name="button" value="Додати">
        </form>
</html>
