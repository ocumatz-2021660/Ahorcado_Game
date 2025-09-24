<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style/loginGame.css"/>
        <link rel="icon" href="Image/logo.png"/>
        <title>Ahorcado GAME</title>
    </head>
    <body>
        <div id="pantallaCarga" class="transicion-negra"></div>
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

        <div class="main-content-wrapper">

            <div class="container-InisioSesion">
                <div class="flip-card-inner">
                    <div class="flip-card-front">
                        <img src="Image/rey.png" alt="Imagen de portada" class="cover-image"/>
                    </div>
                    <div class="flip-card-back">
                        <div class="opciones">
                            <div class="formulario" id="login-form">
                                <-<!-- Validar en accion, obtiene los parametros de txtUsuarios y txtPass para compararlos -->
                                <form action="Validar" method="POST">
                                    <h2>Ahorcado GAME</h2>
                                    <label for="Nombredeusuario">Nombre de usuario</label>
                                    <input autocomplete="off" type="text" placeholder="Usuario" id="login-username" name="txtUsuarioName" required >
                                    <label for="ContraseñaUsuario">Contraseña</label>
                                    <input type="password" placeholder="Contraseña" id="login-password" name="txtPass" required>
                                    <button name="accion" value="Ingresar">Iniciar sesión</button>
                                    <p id="login-error" class="error-msg"></p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="video-container">
                <video autoplay muted loop>
                    <source src="Image/AhorcadoGame.mp4" type="video/mp4">
                    Tu navegador no soporta el tag de video.
                </video>
            </div>

        </div>
        <script src="JavaScript/loginScript.js"></script>
    </body>
</html>