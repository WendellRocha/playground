#include <stdio.h>
/*#include <stdbool.h>*/

main() {
    float media;
    int contador, nota, total;
    total = 0;
    contador = 0;
    printf("Entre com a nota, -1 para finalizar: ");
    scanf("%d", &nota);
    while (nota != -1) {
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
