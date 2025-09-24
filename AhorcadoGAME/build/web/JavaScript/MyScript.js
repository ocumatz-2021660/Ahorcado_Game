
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
let imagenPalabra = '';
let tiempo = 0;
let intervalo;
let letrasAdivinadas = [];
let intentosIncorrectos = 0;
const maxIntentos = 6;
let chosenWordData = {};

const palabrasCollection = [
    {
        palabra: 'motocicleta',
        imagen: 'Image/MotocicletaImage.png'
    },
    {
        palabra: 'carretera',
        imagen: 'Image/carreteraImagen.png'
    },
    {
        palabra: 'laboratorio',
        imagen: 'Image/laboratorioImage.png'
    },
    {
        palabra: 'internet',
        imagen: 'Image/ntenetImage.png'
    },
    {
        palabra: 'terremoto',
        imagen: 'Image/terremotoImage.png'
    },
    {
        palabra: 'tortugas',
        imagen: 'Image/tortugasImage.png'
    },
    {
        palabra: 'profesor',
        imagen: 'Image/profesorImage.png'
    },
    {
        palabra: 'interruptor',
        imagen: 'Image/interruptorImage.png'
    },
    {
        palabra: 'licuadora',
        imagen: 'Image/licuadoraImage.png'
    },
    {
        palabra: 'computadora',
        imagen: 'Image/computadoraImage.png'
    }
];

//Desvanece el contenedor sobrepuesto en el html en 2 segundos
function transicionInicio() {
    //declara el contenedor como pantallanegra
    const pantallaNegra = document.getElementById('pantallaNegra');
    if (pantallaNegra) {
        //0.5 segundos de desvanecimiento
        setTimeout(() => {
            pantallaNegra.style.opacity = '0';
        }, 500);
        //1 segundo para eliminar su display
        setTimeout(() => {
            pantallaNegra.style.display = 'none';
        }, 1000);
    }
}

// declara un intervalo de 1 segundo 
function cronometro() {
    clearInterval(intervalo);
    
    intervalo = setInterval(() => {
        //mientras que el juego no este en pausa y este activo aumenta el tiempo
        if (!enPausa && juegoActivo) {
            tiempo++;
            //divide el tiempo en 60 para minutos y elimina el residuio
            let minutos = Math.floor(tiempo / 60);
            //divide le tiempo en 60 para segundos y elimina el residuo
            let segundos = tiempo % 60;
            //ingresa al contenedor y agrega un 0 al lado de los caracteres que sean diferentes a 2 digitos
            //           reloj.textContent = `${minutos.toString().padStart(2, '0')}:${segundos.toString().padStart(2, '0')}`;
            reloj.textContent = `${minutos.toString().padStart(2, '0')}:${segundos.toString().padStart(2, '0')}`;
            //si el tiempo es mayor o igual a 60 cambia el color del texto de reloj a amarillo
            if (tiempo >= 60)
                reloj.style.color = '#F5D400';
            //si el tiempo es mayor o igual a 75 cambia el color a rojo y lo muestra en formato negrita
            if (tiempo >= 75) {
                reloj.style.color = 'red';
                reloj.style.fontWeight = 'bold';
            }
            //si el tiempo es igual a 90 se pierde el juego
            if (tiempo === 90) {
                pantallaLose();
            }
        }
    }, 1000);
}

function generarTeclado() {
    //limpia el teclado
    teclado.innerHTML = '';
    //declara las 25 letras que vamos a usar
    const letras = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    //recorre la cantidad de letras presente en "letras" 25 en total 
    for (let i = 0; i < letras.length; i++) {
        // delcara un documento como boton y agrega las letras dentro de este como su contenido
        let btn = document.createElement('button');
        btn.textContent = letras[i];
        //si la letra es par tendra un css rojo, si es impar tendra un css negro
        if (i % 2 === 0) {
            btn.className = 'teclado-rojo';
        } else {
            btn.className = 'teclado-negro';
        }
        //metodo cuando se precione el boton
        btn.onclick = function () {
            //si el juego no esta activo salta el metodo
            if (!juegoActivo)
                return;
            //si esta activo, y la letra seleccionada esta incluida dentro de la palabra seleccionada agregara la letra dentro de la palabra seleccionada
            if (palabraSeleccionada.includes(letras[i].toLowerCase())) {
                //si esta incluida la almacena en letrasAdivinadas 
                letrasAdivinadas.push(letras[i].toLowerCase());
            } else {
                //si la letra no esta inlcuida dentro de la palabra selecionada aumetnara el contador de intentos
                intentosIncorrectos++;
                //metodo que cambiara la imagen segun la cantidad de intentos
                errores();
            }
            //dependiendo de las letras encontradas, el metodo mostrara las letras encontradas
            actualizarPalabraMostrada();
            //desavilitara el boton seleccionado
            btn.disabled = true;
            //si se verifica la victoria
            if (verificarVictoria()) {
                //busca si la palabra existe dentro de la coleccion apalbarsColeccion para tener una imagen personalizada o una por defecto
                const palabraEncontrada = palabrasCollection.find(p => p.palabra.toLowerCase() === palabraSeleccionada.toLowerCase());

                if (palabraEncontrada) {
                   //declara imagenPlabara como la palabraOculta
                    imagenPalabra = palabraEncontrada.imagen;
                } else {
                    //si no encuentra la palabra dentro de la coleccion agregara una por dfaul
                    imagenPalabra = "Image/default.png";
                }
                //finaliza el juego y muestra un contendor con informacion de victoria
                detenerJuego();
                document.getElementById('juegoWord').textContent = 'GANASTE';
                document.getElementById('imagenOculta').setAttribute('src', imagenPalabra);
                //metodo de victoria o perdida
                pantallaLose();
            }
        };
        //agrega el boton a la seccion de teclado
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
function mostrarImagenPalabra() {
    const palabraEncontrada = palabrasCollection.find(p => p.palabra.toLowerCase() === palabraSeleccionada.toLowerCase());

    if (palabraEncontrada) {
        imagenPalabra = palabraEncontrada.imagen;
    } else {
        imagenPalabra = "Image/default.png";
    }
    document.getElementById('imagenOculta').setAttribute('src', imagenPalabra);
}
function verificarVictoria() {
    const palabraResuelta = !palabraSeleccionada.split('').some(letra => !letrasAdivinadas.includes(letra));
    if (palabraResuelta) {
        mostrarImagenPalabra();
    }
    return palabraResuelta;
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
    detenerJuego();
    document.getElementById('palabraPerdidaTexto').textContent = 'La palabra era,: ' + palabraSeleccionada.toUpperCase();

    objetoName.textContent = palabraSeleccionada.toUpperCase();
}

function errores() {
    switch (intentosIncorrectos) {
        case 1:
            imgAhorcado.setAttribute('src', 'Image/Error1.jpeg');
            break;
        case 2:
            imgAhorcado.setAttribute('src', 'Image/Error2.jpeg');
            break;
        case 3:
            imgAhorcado.setAttribute('src', 'Image/Error3.jpeg');
            break;
        case 4:
            imgAhorcado.setAttribute('src', 'Image/Error4.jpeg');
            break;
        case 5:
            imgAhorcado.setAttribute('src', 'Image/Error5.jpeg');
            break;
        case 6:
            imgAhorcado.setAttribute('src', 'Image/Error6.jpeg');
            mostrarImagenPalabra();
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
    // Aquí es donde obtenemos los valores de los campos ocultos de palabra y sus atributoz
    palabraSeleccionada = document.getElementById('palabraJuego').value.toLowerCase();
    pist1.textContent = document.getElementById('pista1').value;
    pist2.textContent = document.getElementById('pista2').value;
    pist3.textContent = document.getElementById('pista3').value;
    cronometro();
    actualizarPalabraMostrada();
    generarTeclado();
    document.getElementById('objetoName').textContent = 'Nombre del objeto';
    document.getElementById('pausaGame').style.display = 'none';
    document.getElementById('loseGame').style.display = 'none';
    imgAhorcado.setAttribute('src', 'Image/AhorcadoBase.jpeg');
    botonAccion.src = "Image/botonPausa.png";
    botonAccion.setAttribute('onclick', 'abrirPausa()');
    botonReiniciar.setAttribute('onclick', 'location.reload()');
}
transicionInicio();