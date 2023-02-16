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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.1/flickity.min.css" integrity="sha512-ztsAq/T5Mif7onFaDEa5wsi2yyDn5ygdVwSSQ4iok5BPJQGYz1CoXWZSA7OgwGWrxrSrbF0K85PD5uLpimu4eQ==" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />

    <link rel="stylesheet" href="modificaDati.css">


    <title>Modifica Dati Campi</title>

    <script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>


</head>
<body>

<a class="logo" href="${pageContext.request.contextPath}/home/indexGestore.html" methods="get">
    <img src="${pageContext.request.contextPath}/home/LOGO.jpg" alt="" class="logoimg">
</a>
<h1 class="titolo">MODIFICA E AGGIORNA I TUOI CAMPI!<span class="badge bg-secondary"></span></h1>
<form class="pagina reveal" action="${pageContext.request.contextPath}/modificaDatiCampoServlet" method="get">
    <h2 class="subtitolo">Modifica dati dei campi<span class="badge bg-secondary"></span></h2>
    <c:forEach var="c" items="${campi}">
        <div class="gruppoBottoni">
            <input type="hidden" name="idC" value="<c:out value="${c.nome_c}"/>"><br>
            <div class="input-group mb-3">
                <span class="input-group-text">Nome</span>
                <input type="text" name="nome" value="<c:out value="${c.nome_c}"/>"><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Provincia</span>
                <input type="text" name="provincia" value="<c:out value="${c.provincia}"/>"><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Città</span>
                <input type="text" name="citta" value="<c:out value="${c.citta}"/>"><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Via</span>
                <input type="text" name="via" value="<c:out value="${c.via}"/>"><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Costo</span>
                <input type="text" name="costo" value="<c:out value="${c.costo}"/>"><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Lunghezza</span>
                <input type="text" name="lunghezza" value="<c:out value="${c.lunghezza}"/>"><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Larghezza</span>
                <input type="text" name="larghezza" value="<c:out value="${c.larghezza}"/>"><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Numero Giocatori</span>
                <input type="number" name="num_giocatori" value="<c:out value="${c.num_giocatori}"/>"><br>
            </div>
            <input class="button" type="submit" value="Modifica">
        </div>
        <br>
        <br>
        <br>
    </c:forEach>
</form>

<form class="pagina reveal" action="${pageContext.request.contextPath}/addCampoServlet" method="get">
    <h2 class="subtitolo">Aggiungi un nuovo campo!<span class="badge bg-secondary"></span></h2>
    <div class="gruppoBottoni">
        <input type="hidden" name="idC"><br>
        <div class="input-group mb-3">
            <span class="input-group-text">Nome</span>
            <input type="text" name="nome" value="Nome"><br>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Provincia</span>
            <input type="text" name="provincia" value="Provincia"><br>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Città</span>
            <input type="text" name="citta" value="Citta"><br>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Via</span>
            <input type="text" name="via" value="Via"><br>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Costo</span>
            <input type="text" name="costo" value="Costo"><br>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Lunghezza</span>
            <input type="text" name="lunghezza" value="Lunghezza"><br>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Larghezza</span>
            <input type="text" name="larghezza" value="Larghezza"><br>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Numero Giocatori</span>
            <input type="number" name="num_giocatori" placeholder="Num Giocatori"><br>
        </div>
        <input class="button" type="submit" value="Aggiungi">
    </div>
</form>


<!-- Footer -->
<footer class="footer">
    <div class="grid">

        <div class="col reveal">
            <h4 class="normal-text tw">Annachiara<br>Giugliano<br></h4>
            <h5>0512111849</h5>
        </div>

        <div class="col reveal">
            <h4 class="normal-text tw">Mattia<br>Garofalo<br></h4>
            <h5>0512110994</h5>
        </div>

        <div class="col reveal">
            <h4 class="normal-text tw">Carlo<br>Tammaro<br></h4>
            <p>0512112173</p>
        </div>

        <div class="col reveal">
            <h4 class="normal-text tw">Antonio<br>Renzullo<br></h4>
            <p>0512111906</p>
        </div>

    </div>
</footer>

</body>

<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.1/flickity.pkgd.min.js" integrity="sha512-Nx/M3T/fWprNarYOrnl+gfWZ25YlZtSNmhjHeC0+2gCtyAdDFXqaORJBj1dC427zt3z/HwkUpPX+cxzonjUgrA==" crossorigin="anonymous"></script>

<script>
    $( document ).ready(function() {

        /* Open Panel */
        $( ".hamburger" ).on('click', function() {
            $(".menu").toggleClass("menu--open");
        });

    });


    ScrollReveal().reveal('.reveal');

    ScrollReveal().reveal('.reveal',  { distance: '100px', duration: 1500, easing: 'cubic-bezier(.215, .61, .355, 1)', interval: 600, mobile: false }) ; /*animazione reveal*/

    ScrollReveal().reveal('.zoom',  {  duration: 1500, easing: 'cubic-bezier(.215, .61, .355, 1)', interval: 200, scale: 0.65, mobile: false}); /*animazione zoom*/



</script>

</html>
