<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 05/01/23
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Evento Creato Correttamente</title>
    <link rel="stylesheet" href="eventoCreatoCorrettamente.css">
</head>
<body>
  <h1>Evento creato correttamente</h1>
  <div class="div-img">
      <img class="img" src="eventoOk.webp">
  </div>
  <br>
  <br>

  <script>
      function redirect(){
          location.href = "../../../home/indexUtente.html";
      }
      setTimeout(redirect,3000);
  </script>
</body>
</html>
