#include <stdio.h>

void EsperaEnter() {
	int tecla;
	printf("Pressione a tecla ENTER\n");
	do {
		tecla = getchar();
		if (tecla !+ 13) {
			printf("Pressione a tecla ENTER\n");
		}
	}
	while (tecla != 13);
}