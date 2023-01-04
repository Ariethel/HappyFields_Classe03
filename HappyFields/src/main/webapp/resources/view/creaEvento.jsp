<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HappyFields</title>
</head>
<body>
    <h1>Crea Evento</h1>
    <form name="creaEventoForm" action="../../creaEventoServlet" method="get">
        <input type="text" name="name" placeholder="Titolo"><br>
        <select name = "sport">
            <!-- sia per sport che per campo devo printare le informazioni mettendo i dati nella sessione con una servlet
            (ricordarsi come scrivere codice in java nelle jsp) -->
        </select>
        <select name = "campo">
            <option value = "campo1">campo 1</option>
            <option value = "campo2">campo 2</option>
            <option value = "campo3">campo 3</option>
        </select><br>
        <input type="date" name="data"><br>
        <input type="time" name="ora"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
