def quickSort(vetor,inicio,fim):
    if(inicio < fim):
         q = pQSort(vetor,inicio,fim) #q[0] = pivo; q[1] = inicio; q[2] = fim
         quickSort(vetor, q[1],q[0]-1) #(vetor, inicio, pivo-1)
         quickSort(vetor, q[0]+1,q[2]) #(vetor, pivo+1, fim)
 
def pQSort(vetor,inicio,fim):
     pivo = vetor[fim]
     i = inicio-1

     for j in range(inicio,fim):
         if(vetor[j] <= pivo):
             i += 1
             vetor[i],vetor[j] = vetor[j],vetor[i]
 
     vetor[i+1],vetor[fim] = vetor[fim],vetor[i+1]
     return i+1,inicio,fim