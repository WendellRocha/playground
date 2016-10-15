#include <stdio.h>

main() {
    int votantes = 0, qnt_sim = 0, qnt_nao = 0, qnt_abstencao = 0, votos_totais = 0, quorum_insuf = 0;

    char voto[] = "";
    scanf("%d", &votantes);

    for (int i = 0; i < votantes; i++)
    {
        scanf("%s", &voto);

        if(voto == "sim")
        qnt_sim ++;
        else if(voto == "não")
        qnt_nao ++;
        else if(voto == "abstenção")
        qnt_abstencao++;
    }
    votos_totais = qnt_sim + qnt_nao + qnt_abstencao;
    quorum_insuf = votantes / 2;

    if (votos_totais > quorum_insuf) {
        if (qnt_sim > qnt_nao) {
            printf("materia aprovada");
        }
        else if (qnt_sim < qnt_nao) {
            printf("materia reprovada");
        }
        else if (qnt_sim == qnt_nao) {
            printf("materia aprovada");
        }
    }
    else {
        printf("quorum insuficiente");
    }
}
