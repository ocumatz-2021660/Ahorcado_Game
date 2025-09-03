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
        <div class="container-InisioSesion">
            <div class="opciones">
                <div class="formulario" id="login-form">
                    <h2>Ahorcado GAME</h2>
                    <label for="Nombredeusuario">Nombre de usuario</label>
                    <input type="text" placeholder="Usuario" id="login-username" required>
                    <label for="ContraseñaUsuario">Contraseña</label>
                    <input type="password" placeholder="Contraseña" id="login-password" required>
                    <a href="MenuInicio.jsp">
                        <button onclick="">Iniciar sesión</button>
                    </a>
                    <p id="login-error" class="error-msg"></p>
                </div>     
            </div>
        </div>
        <script src="JavaScript/MyScript.js"></script>
    </body>
</html>
