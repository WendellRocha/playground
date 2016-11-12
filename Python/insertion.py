def insertion(lista):
    i =1;
    j = 0;
    atual = 0;

    for i in range(len(lista)):
        atual = lista[i]
        j = i
        while (j > 0) and (lista[j-1] > atual):
            lista[j] = lista[j-1]
            j = j - 1
        lista[j] = atual

