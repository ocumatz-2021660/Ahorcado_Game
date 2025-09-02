let reloj = document.getElementById('reloj');
let teclado = document.getElementById('tecladoGame');
let palabraOculta = document.getElementById('palabraOculta');
let pist1 = document.getElementById('pistText1');
let pist2 = document.getElementById('pistaText2');
let pist3 = document.getElementById('pistaText3');
let objetoName = document.getElementById('objetoName');
let juegoActivo = false;
let palabraSeleccionada = '';
let tiempo = 0;
let intervalo;
let letrasAdivinadas = [];
let intentosIncorrectos = 0;
const maxIntentos = 6;

const words = [
    {
        word: "motocicleta",
        clues: ["Objeto pesado", "Requiere equilibrio en su uso", "Proporciona mobilidad eficiente"]
    },
    {
        word: "cuaderno",
        clues: ["Utensilio escolar", "material de plastico o carton", "Variedad de estilos"]
    },
    {
        word: "carretera",
        clues: ["Transitas demasiados autos", "Posee asfalto", "tiene normas en su uso"]
    },
    {
        word: "laboratorio",
        clues: ["Enfoque de investigacion", "sigue normas de trabajo y seguridad", "requiere uso profecional"]
    },
    {
        word: "internet",
        clues: ["Uso global", "permite el acceso a multiple informacion", "Es una inovacion humana"]
    },
    {
        word: "terremoto",
        clues: ["Es un desastre natural", "Genera demasiado movimiento", "Se genera en grandes magnitudes"]
    }
];

function cronometro() {
    tiempo = 0;
    reloj.style.color = 'black'; // Restablece el color al inicio
    reloj.style.fontWeight = 'normal'; // Restablece el peso de la fuente
    clearInterval(intervalo);
    intervalo = setInterval(() => {
        tiempo++;
        let minutos = Math.floor(tiempo / 60);
        let segundos = tiempo % 60;
        reloj.textContent = `${minutos.toString().padStart(2, '0')}:${segundos.toString().padStart(2, '0')}`;

        if (tiempo >= 60) {
            reloj.style.color = '#F5D400'; // Amarillo
        }
        if (tiempo >= 75) {
            reloj.style.color = 'red';
            reloj.style.fontWeight = 'bold';
        }
    }, 1000);
}

function generarTeclado() {
    teclado.innerHTML = '';
    const letras = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    for (const letra of letras) {
        const button = document.createElement('button');
        button.textContent = letra;
        button.addEventListener('click', () => encontrarLetra(letra.toLowerCase()));
        teclado.appendChild(button);
    }
}

function encontrarLetra(letra) {
    if (!juegoActivo)
        return;

    const button = Array.from(teclado.children).find(btn => btn.textContent.toLowerCase() === letra);
    if (button)
        button.disabled = true;

    if (palabraSeleccionada.includes(letra)) {
        letrasAdivinadas.push(letra);
    } else {
        intentosIncorrectos++;

    }

    const resuelto = actualizarPalabraMostrada();
}

function actualizarPalabraMostrada() {
    let display = "";
    let resuelto = true;
    for (const letra of palabraSeleccionada) {
        if (letrasAdivinadas.includes(letra)) {
            display += letra.toUpperCase();
        } else {
            display += "_";
            resuelto = false;
        }
        display += " ";
    }
    palabraOculta.textContent = display.trim();
    return resuelto;
}


function desactivarTeclado() {
    teclado.querySelectorAll('button').forEach(btn => btn.disabled = true);
}

function abrirPausa() {
    document.getElementById('pausaGame').style.display = 'flex';
}

function cerrarPausa() {
    document.getElementById("miModal").style.display = "none";
}

function iniciarJuego() {
    juegoActivo = true;
    letrasAdivinadas = [];
    intentosIncorrectos = 0;
    const randomIndex = Math.floor(Math.random() * words.length);
    const chosenWordData = words[randomIndex];
    palabraSeleccionada = chosenWordData.word;
    objetoName.textContent = chosenWordData.category;
    pist1.textContent = chosenWordData.clues[0];
    pist2.textContent = chosenWordData.clues[1];
    pist3.textContent = chosenWordData.clues[2];
    cronometro();
    actualizarPalabraMostrada();
    generarTeclado();
    document.getElementById('pausaGame').style.display = 'none';
}
