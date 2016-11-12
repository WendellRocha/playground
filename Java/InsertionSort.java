import java.util.Arrays;
import java.util.Scanner;

class InsertionSort {

	public static void insertionSort(int[] seq) {

		int i, j, atual;
		
		for (i = 1; i < seq.length; i++) {
			
			atual = seq[i];
			
			j = i;
			
			while ((j > 0) && (seq[j - 1] > atual)) {
				seq[j] = seq[j - 1];
				j = j - 1;
			}
			seq[j] = atual;
			
		}
		
	}
}
