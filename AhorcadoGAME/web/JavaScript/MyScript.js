let reloj = document.getElementById('reloj');
let teclado = document.getElementById('tecladoGame');
let palabraOculta = document.getElementById('palabraOculta');
let pist1 = document.getElementById('pistText1');
let pist2 = document.getElementById('pistaText2');
let pist3 = document.getElementById('pistaText3');
let objetoName = document.getElementById('objetoName');
let botonAccion = document.getElementById('btnAccion');
let botonReiniciar = document.getElementById('btnReiniciar');
let imgAhorcado = document.getElementById('ImagenAhorcado');
let juegoActivo = false;
let enPausa = false;
let estadoJuego = false;
let palabraSeleccionada = '';
let tiempo = 0;
let intervalo;
let letrasAdivinadas = [];
let intentosIncorrectos = 0;
const maxIntentos = 6;
let chosenWordData = {}; // Declarar chosenWordData globalmente

// Ahorraremos espacio de memoria eliminando el array 'palabras' de este script.
// Ahora la palabra y las pistas vienen directamente de la base de datos a través del JSP.

function cronometro() {
    clearInterval(intervalo);
    intervalo = setInterval(() => {
        if (!enPausa && juegoActivo) {
            tiempo++;
            let minutos = Math.floor(tiempo / 60);
            let segundos = tiempo % 60;
            reloj.textContent = `${minutos.toString().padStart(2, '0')}:${segundos.toString().padStart(2, '0')}`;

            if (tiempo >= 60)
                reloj.style.color = '#F5D400';
            if (tiempo >= 75) {
                reloj.style.color = 'red';
                reloj.style.fontWeight = 'bold';
            }
        }
    }, 1000);
}

function generarTeclado() {
    teclado.innerHTML = '';
    const letras = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

    for (let i = 0; i < letras.length; i++) {
        let btn = document.createElement('button');
        btn.textContent = letras[i];

        if (i % 2 === 0) {
            btn.className = 'teclado-rojo';
        } else {
            btn.className = 'teclado-negro';
        }

        btn.onclick = function () {
            if (!juegoActivo)
                return;

            if (palabraSeleccionada.includes(letras[i].toLowerCase())) {
                letrasAdivinadas.push(letras[i].toLowerCase());
            } else {
                intentosIncorrectos++;
                errores();
            }

            actualizarPalabraMostrada();
            btn.disabled = true;

            if (verificarVictoria()) {
                detenerJuego();
                document.getElementById('juegoWord').textContent = 'GANASTE';
                pantallaLose();
            }
        };

        teclado.appendChild(btn);
    }
}

function actualizarPalabraMostrada() {
    let palabraOcul = "";
    let resuelto = true;
    for (const letra of palabraSeleccionada) {
        if (letrasAdivinadas.includes(letra)) {
            palabraOcul += letra.toUpperCase();
        } else {
            palabraOcul += "_";
            resuelto = false;
        }
        palabraOcul += " ";
    }
    palabraOculta.textContent = palabraOcul.trim();
    return resuelto;
}

function verificarVictoria() {
    return !palabraSeleccionada.split('').some(letra => !letrasAdivinadas.includes(letra));
}

function detenerJuego() {
    juegoActivo = false;
    clearInterval(intervalo);
}

function mostrarPausa() {
    enPausa = true;
    document.getElementById('pausaGame').style.display = 'flex';
}

function abrirPausa() {
    enPausa = true;
    clearInterval(intervalo);
    document.getElementById('pausaGame').style.display = 'flex';
}

function cerrarPausa() {
    enPausa = false;
    document.getElementById("pausaGame").style.display = "none";
    cronometro();
}

function cerrarJuego() {
    location.reload();
}

function pantallaLose() {
    estadoJuego = true;
    document.getElementById('loseGame').style.display = 'flex';
    detenerJuego(); // Se detiene el cronómetro al perder

    if (estadoJuego === true) {
        // Al perder, muestra la palabra completa
        objetoName.textContent = palabraSeleccionada.toUpperCase();
    }
}

function errores() {
    switch (intentosIncorrectos) {
        case 1:
            imgAhorcado.setAttribute('src', 'Image/Error1.png');
            break;
        case 2:
            imgAhorcado.setAttribute('src', 'Image/Error2.png');
            break;
        case 3:
            imgAhorcado.setAttribute('src', 'Image/Error3.png');
            break;
        case 4:
            imgAhorcado.setAttribute('src', 'Image/Error4.png');
            break;
        case 5:
            imgAhorcado.setAttribute('src', 'Image/Error5.png');
            break;
        case 6:
            imgAhorcado.setAttribute('src', 'Image/Error6.png');
            pantallaLose();
            break;
        default:
            break;
    }
}

function iniciarJuego() {
    tiempo = 0;
    juegoActivo = true;
    enPausa = false;
    estadoJuego = false;
    letrasAdivinadas = [];
    intentosIncorrectos = 0;

    // Aquí es donde obtenemos los valores de los campos ocultos
    palabraSeleccionada = document.getElementById('palabraJuego').value;
    pist1.textContent = document.getElementById('pista1').value;
    pist2.textContent = document.getElementById('pista2').value;
    pist3.textContent = document.getElementById('pista3').value;
    cronometro();
    actualizarPalabraMostrada();
    generarTeclado();
    document.getElementById('objetoName').textContent = 'Nombre del objeto';
    document.getElementById('pausaGame').style.display = 'none';
    document.getElementById('loseGame').style.display = 'none';
    imgAhorcado.setAttribute('src', 'Image/Ahorcado.png');
    botonAccion.src = "Image/botonPausa.png";
    botonAccion.setAttribute('onclick', 'abrirPausa()');
    botonReiniciar.setAttribute('onclick', 'location.reload()');
}