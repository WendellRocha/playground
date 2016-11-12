import java.util.*;

class ParticionaMantendoOrdem {
    
    private static void particiona(int[] array) {
        int pivot = array[0];
        int i = 0;

		for (int j = 1; j < array.length; j++) {
			if (array[j] <= pivot) {
                for (int k = j; k > i; k--) {
                    swap(array,k,k-1);
                }
				i+=1;
			}
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
