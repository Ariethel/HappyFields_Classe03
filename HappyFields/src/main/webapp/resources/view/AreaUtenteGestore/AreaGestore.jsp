<%--
  Created by IntelliJ IDEA.
  User: carlotammaro
  Date: 20/01/23
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.1/flickity.min.css" integrity="sha512-ztsAq/T5Mif7onFaDEa5wsi2yyDn5ygdVwSSQ4iok5BPJQGYz1CoXWZSA7OgwGWrxrSrbF0K85PD5uLpimu4eQ==" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />

    <link rel="stylesheet" href="areaUtenteGestore.css">


    <title>AreaGestore</title>

    <script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<a class="logo" href="${pageContext.request.contextPath}home/index.html">
    <img src="${pageContext.request.contextPath}/home/LOGO.jpg" alt="" class="logoimg">
</a>

<h1 class="titolo zoom"> Benvenuti nella vostra area gestore! </h1>

<div>
    <div class="pagina zoom">
        <div class="gruppo-bottoni">
            <form action="../ModificaDati/ModificaDatiGestore.jsp">
                <input type="submit" value="Modifica Dati" class="button">
            </form>
            <form action="${pageContext.request.contextPath}/fillCampiGestoreServlet">
                <input type="submit" value="Modifica Campi" class="button">
            </form>
            <form action="${pageContext.request.contextPath}/fillEventiAttesa" method="get">
                <input type="submit" value="Visualizza eventi in attesa" class="button">
            </form>
            <form action="${pageContext.request.contextPath}/eliminaAccountServlet">
                <input type="submit" value="Elimina Account" class="button">
            </form>
        </div>
    </div>
</div>



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

</body>
</html>
