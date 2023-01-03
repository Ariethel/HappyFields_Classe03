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

    <h3>Utente</h3>
    <div>
        <form name="loginform" action="../../loginUtenteServlet" method="post">
            <input type="text" placeholder="username *" name="username" required pattern="^[a-z0-9]{4,15}$" title="Il campo Username deve contenere 4-15 caratteri"><br>
            <input type="password" placeholder="password *" name="password" required pattern="^[A-Za-z0-9]{4,15}$" title="Il campo Password deve contenere 4-15 caratteri"><br>
            <input type="text" placeholder="provincia *" name="provincia" required pattern="^[A-Z]{2,2}$" title="Il campo Provincia deve contenere max 2 caratteri"><br>
            <input type="text" placeholder="citta *" name="citta" required><br>
            <input type="text" placeholder="via *" name="via" required><br>
            <input type="number" placeholder="telefono *" name="telefono" required><br>
            <input type="text" placeholder="iban" name="iban"><br>
            <!-- la preferenza volevo metterla come un dropdown menu ma in questo momento non mi ricordo come si fa, poi ci penso -->
            <input type="hidden" placeholder="preferenza" name="preferenza"><br>
            <input type="submit" formaction="../../registerUtenteServlet" value="Register">
            <input type="submit" value="Submit">
        </form>
    </div>

    <br>


    <!-- Fare le servlet di registrazione gestore -->
    <h3>Gestore</h3>
    <div>
        <form name="loginform" action="../../loginGestoreServlet" method="post">
            <input type="text" placeholder="username *" name="username" required pattern="^[a-z0-9]{4,15}$" title="Il campo Username deve contenere 4-15 caratteri"><br>
            <input type="password" placeholder="password *" name="password" required pattern="^[a-z0-9]{4,15}$" title="Il campo Password deve contenere 4-15 caratteri"><br>
            <input type="text" placeholder="nome *" name="nome" required><br>
            <input type="text" placeholder="cognome *" name="cognome" required><br>
            <input type="text" placeholder="provincia *" name="provincia" required pattern="^[A-Z]{2,2}$" title="Il campo Provincia deve contenere max 2 caratteri"><br>
            <input type="text" placeholder="citta *" name="citta" required><br>
            <input type="text" placeholder="via *" name="via" required><br>
            <input type="number" placeholder="telefono *" name="telefono" required><br>
            <input type="text" placeholder="iban *" name="iban"><br>
            <input type="submit" formaction="../../registerGestoreServlet" value="Register">
            <input type="submit" value="Submit">
        </form>
    </div>
</div>

</body>
</html>
