def selection(lista):
    for i in range(0, len(lista)):
        menor = i
        for j in range(i, len(lista)):
            if lista[j] < lista[menor]:
                menor = j
        lista[menor], lista[i] = lista[i], lista[menor]
    return lista

def sort(lista1):
    n = len(lista1)
    for i in range(n-1):
        m = i
        for j in range(i+1, n):
            if(lista1[j] < lista1[m]):
                m = j
        lista1[i], lista1[m] = lista1[m], lista1[i]
    return lista1

lista1 = [7, -14, 21]
lista = [9, 2, 3, 1, 8, 0, 4, 6, 7, 5]
assert sort(lista1) == [-14, 7, 21]
assert selection(lista) == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
