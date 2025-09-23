<%--
    Document   : index
    Created on : 1/09/2025, 16:51:03
    Author     : Oscar Cumatzz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style/StyleGame.css"/>       
        <link rel="icon" href="Image/logo.png"/>
        <title>Ahorcado GAME</title>
    </head>
    <body>
        <video autoplay muted loop id="bg-video">
            <source src="Image/GameFondo.mp4" type="video/mp4">
        </video>
        <header class="encabezado">
            <div class="logoImage">
                <img src="Image/logo.png" alt="Logo"/>
                <span class="logo-text">
                    <span>Ahorcado</span>
                    <span>GAME</span>
                </span>
            </div>
        </header>

        <%-- Aquí se añaden los campos ocultos para pasar los datos a JavaScript --%>
        <input type="hidden" id="palabraJuego" value="${palabraJuego.nombre_Palabra}">
        <input type="hidden" id="pista1" value="${palabraJuego.pista_Uno}">
        <input type="hidden" id="pista2" value="${palabraJuego.pista_Dos}">
        <input type="hidden" id="pista3" value="${palabraJuego.pista_Tres}">

        <div class="arcade-screen-container">

            <div class="contenido-general">
                <div class="contenido-ahorcado">      
                    <img src="Image/Ahorcado.png" alt="Ahorcado.png" id="ImagenAhorcado"/>
                </div>
                <div class="contenido-informacion">        
                    <div class="contenido-pistas">

                        <div class="contenido-pistas-left">

                            <div class="tiempo">
                                <p class="time" id="reloj">00:00</p>
                            </div>

                            <div class="pistas">
                                <p id="pistText1">* Pista No.1</p>
                                <p id="pistaText2">* Pista No.2</p>
                                <p id="pistaText3">* Pista No.3</p>
                            </div>
                        </div>

                        <div class="contenido-pistas-right">                        
                            <p id="objetoName">Nombre del objeto</p>
                            <img id="imagenOculta" src="Image/objetoAleatorio.png" alt="ImagenObjeto"/>
                        </div>
                    </div>
                    <div class="contenido-interacciones">
                        <div class="contenido-palabra">
                            <h2>Palabra</h2>
                            <p id="palabraOculta">_ _ _ _ _ _ _ _</p>
                        </div>
                    </div>
                </div>            
                <div>
                    <a href="index.jsp">
                        <button class="salir">X</button>
                    </a>
                </div>
            </div>
        </div> 
        <div class="seccionBTN">
            <div class="contenedor-button" >
                <div class="btn-arcade">
                    <img id="btnAccion" src="Image/botonIniciar.png" alt="iniciar" onclick="iniciarJuego()"/>           
                </div>                               
            </div>
            <div class="contenedor-button" >
                <div class="btn-arcade">
                    <img id="btnReiniciar" src="Image/botonReiniciar.png" alt="reiniciar"/>
                </div>                               
            </div>
        </div>
        <div class="contenido-teclado" id="tecladoGame"></div>

        <div id="pausaGame" class="estadoGame">

            <div class="contenidoPausa">         
                <div id="btnPausa" class="seccionPausa">                 
                    <h1>PAUSA</h1>   
                    <img src="Image/botonIniciar.png" alt="continuar" onclick="cerrarPausa()"/>
                    <img src="Image/botonSalir.png" alt="Salir" onclick="cerrarJuego()"/>
                </div>
            </div>
        </div>
        <div id="loseGame" class="estadoGame">
            <div class="contenidoPausa">         
                <div id="btnPausa" class="seccionPausa">                 
                    <h1 id="juegoWord">JUEGO PERDIDO</h1>                      
                    <img src="Image/botonReiniciar.png" alt="Reiniciar" onclick="cerrarJuego()"/>
                    <img src="Image/botonSalir.png" alt="Salir" onclick="cerrarJuego()"/>
                </div>
            </div>
        </div>
        <script src="JavaScript/MyScript.js"></script>
    </body>
</html>