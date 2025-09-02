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
        <link rel="stylesheet" href="Style/StyleCss.css"/>        
        <link rel="icon" href="Image/logo.png"/>
        <title>Ahorcado GAME</title>
    </head>
    <body>
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
                            <p id="pistText1">pista1</p>
                            <p id="pistaText2">pista2</p>
                            <p id="pistaText3">pista3</p>
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
                        <button>Reiniciar</button>
                        <button>Pausar</button>
                        <button>Salir</button>
                    </div>
                </div>
            </div>

        </div>
            
            <script src="JavaScript/MyScript.js"></script>
    </body>
</html>
