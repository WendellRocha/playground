#include <stdio.h>

main() {
 int i = 0;
 do {
    if (i % 2 == 0) {
        printf("O numero %d e par\n", i);
        i++;
    }
    else {
        printf("O numero %d e impar\n", i);
        i++;
    }
 } while (i <= 100);
}
