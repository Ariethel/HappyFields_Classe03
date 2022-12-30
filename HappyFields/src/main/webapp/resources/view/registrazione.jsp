<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 30/12/22
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HappyFields</title>
</head>
<body>

<!-- From di login -->
<div>
    <h1>Benvenuto</h1>

    <h3>Registrazione utente</h3>
    <div>
        <form name="loginform" action="../../loginUtenteServlet" method="post">
            <input type="text" placeholder="username" name="username" required pattern="^[a-z0-9]{4,15}$" title="Il campo Username deve contenere 4-15 caratteri"><br>
            <input type="password" placeholder="password" name="password" required pattern="^[a-z0-9]{4,15}$" title="Il campo Password deve contenere 4-15 caratteri"><br>
            <input type="submit" formaction="../../registerUtenteServlet" value="Register">
            <input type="submit" value="Submit">
        </form>
    </div>

    <br>


    <!-- Fare le servlet di registrazione gestore -->
    <h3>Registrazione gestore</h3>
    <div>

    </div>
</div>

</body>
</html>
