function condicao() {
    while(form1.nome.value=="") {
        alert("Por favor, preencha o campo");
            form1.nome.value=prompt("Digite o seu nome:","");
    }
    alert("Obrigado!", +form1.nome.value);
}