<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 31/01/23
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Happy Fields</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/modificaDatiCampoServlet" method="get">
    <c:forEach var="c" items="${campi}">
        <input type="hidden" name="idC" value="<c:out value="${c.nome_c}"/>"><br>
        <input type="text" name="nome" value="<c:out value="${c.nome_c}"/>"><br>
        <input type="text" name="provincia" value="<c:out value="${c.provincia}"/>"><br>
        <input type="text" name="citta" value="<c:out value="${c.citta}"/>"><br>
        <input type="text" name="via" value="<c:out value="${c.via}"/>"><br>
        <input type="text" name="costo" value="<c:out value="${c.costo}"/>"><br>
        <input type="text" name="lunghezza" value="<c:out value="${c.lunghezza}"/>"><br>
        <input type="text" name="larghezza" value="<c:out value="${c.larghezza}"/>"><br>
        <input type="number" name="num_giocatori" value="<c:out value="${c.num_giocatori}"/>"><br>
        <input type="submit" value="Modifica">
        <br>
        <br>
        <br>
    </c:forEach>
</form>

<h3> Aggiungi Campo</h3>
<form action="${pageContext.request.contextPath}/addCampoServlet" method="get">
        <input type="hidden" name="idC"><br>
        <input type="text" name="nome" value="Nome"><br>
        <input type="text" name="provincia" value="Provincia"><br>
        <input type="text" name="citta" value="Citta"><br>
        <input type="text" name="via" value="Via"><br>
        <input type="text" name="costo" value="Costo"><br>
        <input type="text" name="lunghezza" value="Lunghezza"><br>
        <input type="text" name="larghezza" value="Larghezza"><br>
        <input type="number" name="num_giocatori" placeholder="Num Giocatori"><br>
        <input type="submit" value="Aggiungi">
</form>
</body>
</html>
