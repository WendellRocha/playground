#include <stdio.h>

main() {
    float media;
    int contador, nota, total;
    total = 0;
    contador = 0;
    printf("Entre com a nota, -1 para finalizar: ");
    scanf("%d", &nota);
    for(;;) {
        if(nota == -1) { break;}
        total += nota;
        contador++;
        printf("Entre com a nota, -1 para finalizar: ");
        scanf("%d", &nota);
    }
    if  (contador != 0) {
        media = (float) total / contador;
        printf ("A media da turma e %.2f", media);
    }
    else {
        printf("Nenhuma nota foi fornecido\n");
    }
}
