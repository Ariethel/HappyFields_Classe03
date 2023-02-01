<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 01/02/23
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Happy Fields</title>
</head>
<body>
<c:forEach var="evento" items="${eventi}">
  <form action="${pageContext.request.contextPath}/partecipaEventoServlet" method="get">
    <tr>
      <td><c:out value="${evento.nome}"/></td><br>
      <td><c:out value="${evento.campo.getIndirizzoCompleto()}"/></td><br>
      <td><c:out value="${evento.sport.getNome_s()}"/></td><br>
      <td><c:out value="${evento.campo.getNome_c()}"/></td><br>
      <td><c:out value="${evento.data}"/></td><br>
      <td><c:out value="${evento.ora}"/></td><br>
    </tr>
    <input type="hidden" name="nome_e" value="${evento.getNome()}">
    <input type=submit value="Partecipa">
    <br>
    <br>
    <br>
  </form>
</c:forEach>

</body>
</html>
