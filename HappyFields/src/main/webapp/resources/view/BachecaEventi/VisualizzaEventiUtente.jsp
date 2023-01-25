<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 25/01/23
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Happy Fields</title>
</head>
<body>

<c:forEach var="evento" items="${eventi}">
        <tr>
            <td><c:out value="${evento.nome}"/></td><br>
            <td><c:out value="${evento.campo.getIndirizzoCompleto()}"/></td><br>
            <td><c:out value="${evento.sport.getNome_s()}"/></td><br>
            <td><c:out value="${evento.campo.getNome_c()}"/></td><br>
            <td><c:out value="${evento.data}"/></td><br>
            <td><c:out value="${evento.ora}"/></td><br>
        </tr>
        <br>
        <br>
        <br>
</c:forEach>


</body>
</html>
