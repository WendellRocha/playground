#include <stdio.h>

main() {


    for(int i = 0; i <= 10; i++) {
        if (i < 10) {
            if (i % 2 == 0){
                printf("%d e par\n", i);
            }
            else if (i % 2 != 0) {
                printf("%d e impar\n", i);
            }
        }
        else {
            printf("%d e maior ou igual a 10\n", i);
        }
    }
}
