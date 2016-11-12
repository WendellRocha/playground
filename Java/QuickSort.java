import java.util.*;

class QuickSort {

    public static void quick(int[] v, int left, int right) {
        if (left < right) {
            int pivot = particiona(v, left, right);
            quick(v,left,pivot-1);
            quick(v,pivot+1,right);
        }
    }
    
    public static int particiona(int[] v, int left, int right) {
        int i = left;
        int j = i + 1;
        int pivot = v[left];

        while (j < v.length) {
        
            if (v[j] < pivot) {
                i+=1;
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux; 
            }

            j+=1;
        
        }
        
        int aux = v[left];
        v[left] = v[i];
        v[i] = aux;
        return i;
    }

}