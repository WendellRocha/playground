def bubble(lista):
    for i in range(len(lista)):
        for j in range(len(lista)-1. i, -1):
            if(lista[j] < lista[j - 1]):
                swap(lista, j, j - 1)

def swap(lista, x, y):
    tmp = lista[x]
    lista[x] = lista[y]
    lista[y] = tmp


    
