import java.util.*;

public class CountingSort {

	public static int[] counting(int[] a, int menor, int k) {

		int[] c = new int[k - menor + 1];
		
		for (int e : a) {
			c[e - menor]++;
		}
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		int[] aux = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--){
			aux[c[a[i]-menor]-1] = a[i];
			c[a[i]-menor]--;
		}
		
		return aux;
	}

}