<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HappyFields</title>
</head>
<body>
    <h1>Crea Evento</h1>
    <form name="creaEventoForm" action="../../creaEventoServlet" method="get">
        <input type="text" name="name" placeholder="Titolo"><br>
        <!-- Stampo dinamicamente sport e campi disponibili senza fare direttamente l'accesso al DB dalla jsp -->
        <select name = "sport">
            <c:forEach items="${sport}" var="s">
                <option>${s}</option>
            </c:forEach>
        </select>
        <select name = "campo">
            <c:forEach items="${campo}" var="c">
                <option>${c}</option>
            </c:forEach>
        </select><br>
        <input type="date" name="data"><br>
        <input type="time" name="ora"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
