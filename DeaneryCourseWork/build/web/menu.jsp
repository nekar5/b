<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Меню</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <h1>Меню вибору</h1>
        <a href="/DeaneryCourseWork/allGroups.jsp">Списки груп</a> <br>
        <a href="/DeaneryCourseWork/search.jsp">Пошук груп</a> <br>
        <c:if test = "${login !=null}">
            <a href="/DeaneryCourseWork/addGroup.jsp">Додати групу</a><br>
            <a href="/DeaneryCourseWork/addStudent.jsp">Додати студента</a><br>
            <a href="/DeaneryCourseWork/deleteGroup.jsp">Видалити групу</a><br>
            <br>
            <form method="link" action="logout.jsp">
                <input type="submit" name="enter" value="Вихід"/>
            </form>

        </c:if>
    </body>
</html>
