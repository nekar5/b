<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Група ${group.name}</title>
    </head>
    <body>
        <% request.getSession().setAttribute("action", "deletestudent");%>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <h1>Група ${group.name}</h1>
        <table width="400" border="0" cellspacing="0" cellpadding="0" align="center">
            <tr style="text-align:center;">
                <th>Номер в списку</th>
                <th>Ім'я студента</th>
                <th>Прізвище студента</th>
                <th>Середній бал студента</th>
            </tr>
            <c:forEach var="student" items="${group.students}" varStatus="loop" >
                <tr style="text-align:center;">
                    <td>${loop.index+1}</td>
                    <td>${student.name}</td>
                    <td>${student.surname}</td>
                    <td>${student.rating}</td>
                </tr>
            </c:forEach>
        </table>
        <c:if test = "${login !=null}">
            <form action="FrontController" method="POST">
                <h1>Видалення студента по номеру в списку</h1>
                <label for="index">Введіть номер студенту якого потрібно видалити</label>
                <input type="number" name="index" placeholder="Введіть номер студенту" required> <br>
                <input type="submit" name="button" value="Видалити">
                <input type="hidden" name="groupName" value="${group.name}">
            </form>
        </c:if>
    </body>
</html>
