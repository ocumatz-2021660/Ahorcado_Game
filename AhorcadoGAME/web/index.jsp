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
        <header>
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
                <img src="Image/EjemploAhorcado.png" alt="Ahorcado.png"/>
            </div>
            <%--Apartado para msotrar la palabra, cualidades e interacciones --%>
            <div class="contenido-informacion">                    
                <div class="contenido-pistas">

                    <div class="contenido-pistas-left">

                        <div class="tiempo">
                            <p class="time" id="reloj">00:00</p>
                        </div>

                        <div class="pistas">
                            <p id="pistText1">pista 1</p>
                            <p id="pistaText2">pista 2</p>
                            <p id="pistaText3">pista 3</p>
                        </div>

                    </div>

                    <div class="contenido-pistas-right">                                                
                        <p id="objetoName">Objeto</p>
                        <img src="Image/objetoAleatorio.png" alt="ImagenObjeto"/>
                    </div>

                </div>
                <div class="contenido-interacciones">
                    <div class="contenido-palabra">
                        <h2>Palabra</h2>
                        <p id="palabraOculta">_ _ _ _ _ _ _ _</p>
                    </div>
                    <div class="seccionBTN">
                        <button  class="btnStar" onclick="iniciarJuego()">Iniciar</button>
                        <button onclick="abrirPausa()">Pausar</button>
                        <button>Reiniciar</button>
                    </div>
                </div>
            </div>                    

        </div>

        <div class="contenido-teclado" id="tecladoGame"></div>

        <div id="pausaGame" class="estadoGame">

            <div class="contenidoPausa">           
                <div id="btnPausa" class="seccionPausa">                    
                    <h1>PAUSA</h1>    
                    <button>Continuar</button>
                    <button onclick="iniciarJuego()">Reiniciar</button>
                </div>
            </div>

        </div>
        <script src="JavaScript/MyScript.js"></script>
    </body>
</html>
