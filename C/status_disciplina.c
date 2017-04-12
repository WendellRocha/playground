#include <stdio.h>

main() {
    float n1, n2, n3, media;
    int faltas_a, faltas;

    scanf("%f", &n1);
    scanf("%f", &n2);
    scanf("%f", &n3);
    scanf("%d", &faltas_a);

    faltas = 30 - faltas_a;
    media = (n1 + n2 + n3) / 3;

    if ((faltas >= 23) && (media >= 7.0)) {
        printf("aprovado por media");
    }
    else if ((faltas >= 23) && (media < 4.0)) {
        printf("reprovado por nota");
    }
    else if ((faltas < 23) && (media <= 7.0 || media >= 7.0)) {
        printf("reprovado por faltas");
    }
    else if ((faltas >= 23) && (media > 4.0 && media < 7.0)) {
        printf("prova final");
    }
}


