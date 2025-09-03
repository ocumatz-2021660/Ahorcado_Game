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

const palabras = [
    {
        palabra: "motocicleta",
        pistas: ["Objeto pesado", "Requiere equilibrio en su uso", "Proporciona mobilidad eficiente"]
    },
    {
        palabra: "cuaderno",
        pistas: ["Utensilio escolar", "material de plastico o carton", "Variedad de estilos"]
    },
    {
        palabra: "carretera",
        pistas: ["Transitas demasiados autos", "Posee asfalto", "tiene normas en su uso"]
    },
    {
        palabra: "laboratorio",
        pistas: ["Enfoque de investigacion", "sigue normas de trabajo y seguridad", "requiere uso profecional"]
    },
    {
        palabra: "internet",
        pistas: ["Uso global", "permite el acceso a multiple informacion", "Es una inovacion humana"]
    },
    {
        palabra: "terremoto",
        pistas: ["Es un desastre natural", "Genera demasiado movimiento", "Se genera en grandes magnitudes"]
    }
];

function cronometro() {
    clearInterval(intervalo); // limpiar cualquier intervalo anterior
    intervalo = setInterval(() => {
        if (!enPausa && juegoActivo) { // solo contar tiempo si no está en pausa
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

        // alternar color rojo/negro
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

            // actualizar palabra y deshabilitar la tecla
            actualizarPalabraMostrada();
            btn.disabled = true;

            // Verificar si se ha ganado después de cada intento
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
    // Si todas las letras han sido adivinadas, se gana
    return !palabraSeleccionada.split('').some(letra => !letrasAdivinadas.includes(letra));
}

function detenerJuego() {
    juegoActivo = false;
    clearInterval(intervalo); // Detener el cronómetro
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
    cronometro();

    if (estadoJuego === true) {        
        objetoName.textContent = chosenWordData.palabra;
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
    const randomIndex = Math.floor(Math.random() * palabras.length);
    chosenWordData = palabras[randomIndex]; // Asignar palabra a la variable global
    palabraSeleccionada = chosenWordData.palabra;
    pist1.textContent = chosenWordData.pistas[0];
    pist2.textContent = chosenWordData.pistas[1];
    pist3.textContent = chosenWordData.pistas[2];
    cronometro();
    actualizarPalabraMostrada();
    generarTeclado();
    document.getElementById('objetoName').textContent = 'Nombre del objeto';
    document.getElementById('pausaGame').style.display = 'none';
    document.getElementById('loseGame').style.display = 'none';
    imgAhorcado.setAttribute('src', 'Image/Ahorcado.png');
    botonAccion.src = "Image/botonPausa.png";
    botonAccion.setAttribute('onclick', 'abrirPausa()');
    botonReiniciar.setAttribute('onclick', 'iniciarJuego()');
}
