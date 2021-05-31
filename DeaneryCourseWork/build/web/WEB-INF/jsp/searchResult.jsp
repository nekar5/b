<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Результат пошуку</title>
    </head>
    <body>

        <jsp:include page="/WEB-INF/jsp/header.jsp"/>
         <h1>Результат пошуку</h1>
            <c:set var="serchResult" value="${requestScope.serchResult}"></c:set>
        <ol>
        <c:forEach var="group" items="${serchResult}" >
           <li> <a href="http://localhost:8084/DeaneryCourseWork/GroupController?name=${group.name}">${group.name}</a></li>
    </c:forEach>
    </ol>
    </body>
</html>
