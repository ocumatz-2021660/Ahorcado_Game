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
            <source src="Image/fondoGame.mp4" type="video/mp4">
        </video>
        <div class="overlay"></div>
        <header class="encabezado">
            <div class="logoImage">
                <img src="Image/logo.png" alt="Logo"/>
                <span class="logo-text">
                    <span>Ahorcado</span>
                    <span>GAME</span>
                </span>
            </div>
        </header>
        <%-- apartado para separar la informacion que muestra avances y las interacciones con el usuario --%>
        <div class="contenido-general">
            <%--Apartado para mostrar al muñeco (progreso de ahorcado) --%>
            <div class="contenido-ahorcado">            
                <img src="Image/Ahorcado.png" alt="Ahorcado.png" id="ImagenAhorcado"/>
            </div>
            <%--Apartado para msotrar la palabra, cualidades e interacciones --%>
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
                        <img src="Image/objetoAleatorio.png" alt="ImagenObjeto"/>
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
        <div class="seccionBTN">
            <img id="btnAccion" src="Image/botonIniciar.png" alt="iniciar" onclick="iniciarJuego()"/>
            <img id="btnReiniciar" src="Image/botonReiniciar.png" alt="reiniciar"/>
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
                    <img src="Image/botonReiniciar.png" alt="Reiniciar" onclick="iniciarJuego()"/>
                    <img src="Image/botonSalir.png" alt="Salir" onclick="cerrarJuego()"/>
                </div>
            </div>
        </div>
        <script src="JavaScript/MyScript.js"></script>
    </body>
</html>
