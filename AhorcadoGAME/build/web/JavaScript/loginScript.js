function transicionInicio() {
    //declara el contenedor como pantallanegra
    const pantallaNegra = document.getElementById('pantallaCarga');
    if (pantallaNegra) {
        //0.6 segundos de desvanecimiento
        setTimeout(() => {
            pantallaNegra.style.opacity = '0';
        }, 650);
        //1.5 segundo para eliminar su display
        setTimeout(() => {
            pantallaNegra.style.display = 'none';
        }, 1500);
    }
}
transicionInicio();

