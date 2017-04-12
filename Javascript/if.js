function condicao() {
    if(form1.nome.value=="") {
        alert("Por favor, preencha o campo");
        return form1.nome.focus();
    } else {
        alert("Obrigado, "+form1.nome.value);
    }
}