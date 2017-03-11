function primeiraFuncao() {
    alert("Primeira função");
}

function relogio() {
    tempo = new Date();
    hora = tempo.getHours();
    minutos = tempo.getMinutes();
    segundos = tempo.getSeconds();
    if(segundos <10) {
        segundos = "0" + segundos;
    }
    document.write(hora + ":" + minutos + ":" + segundos);
    setTimeout("relogio()", "1000");
}