let reloj = document.getElementById('reloj');
let tiempo = 0;
let intervalo;

function cronometro() {
    tiempo = 0;
    clearInterval(intervalo);
    intervalo = setInterval(() => {
        tiempo++;
        let minutos = Math.floor(tiempo / 60);
        let segundos = tiempo % 60;
        reloj.textContent = `${minutos.toString().padStart(2, '0')}:${segundos.toString().padStart(2, '0')}`;
        if (tiempo >= 90) {
            clearInterval(intervalo);
        }
        if (tiempo >= 60) {
            reloj.style.color = '#F5D400';
        }
        if (tiempo >= 75) {
            reloj.style.color = 'red';
            reloj.style.fontWeight = 'bold';
        }
    }, 1000);
}

window.onload = () => cronometro();