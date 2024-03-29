<%--
  Created by IntelliJ IDEA.
  User: carlotammaro
  Date: 23/01/23
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>Contatti</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />

  <link rel="stylesheet" href="contatti.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.1/flickity.min.css" integrity="sha512-ztsAq/T5Mif7onFaDEa5wsi2yyDn5ygdVwSSQ4iok5BPJQGYz1CoXWZSA7OgwGWrxrSrbF0K85PD5uLpimu4eQ==" crossorigin="anonymous" />

  <script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>

</head>
<body>
<div class="img">
  <!-- Logo -->
  <div class="logodiv zoom">
    <a class="logo" href="${pageContext.request.contextPath}/home/index.html">
      <img src="${pageContext.request.contextPath}/home/LOGO.jpg" alt="" class="logoimg">
    </a>
  </div>

  <!-- Memoji -->
  <h1>BENVENUTI IN HAPPYFIELDS! QUI POTRETE TROVARE TUTTI I NOSTRI CONTATTI!</h1>
  <img id="c" class="immagine zoom" src="images/Carlo-sticker.png">
  <img id="a" class="immagine zoom" src="images/Annachiara-sticker.png">
  <img id="g" class="immagine zoom" src="images/Mattia-sticker.png">
  <img id="ant" class="immagine zoom" src="images/Antonio-sticker.png">
</div>

<!-- Social -->
<div class="social zoom"><br><br>

  <img class="social-img zoom" id="twitter" src="images/twitter-logo.png">
  <label class="social-label zoom" for="twitter">HappyFields_4</label><br><br>

  <img class="social-img zoom" id="facebook" src="images/facebook-logo.png">
  <label class="social-label zoom" for="facebook">HappyFields</label><br><br>

  <img class="social-img zoom" id="insta" src="images/instagram-logo.png">
  <label class="social-label zoom" for="insta">HappyFields</label><br><br>

  <img class="social-img zoom" id="email" src="images/gmail-logo.jpeg">
  <label class="social-label zoom" for="email">Email: happyfields@gmail.com</label><br><br>

  <img class="social-img zoom" id="numero" src="images/tel-logo.jpeg">
  <label class="social-label zoom" for="numero">Numero Verde: 800556021</label><br><br>



</div>




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
