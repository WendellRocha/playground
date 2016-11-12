import java.util.Arrays;

class SelectionSortSteps {

    public static void selectionSort(int[] seq) {
		int i, j, minIndex, temp;
		int n = seq.length;

		for (i = 0; i < n - 1; i++) {
			minIndex = i;
			for (j = i + 1; j < n; j++)
				if (seq[j] < seq[minIndex])
					minIndex = j;
			if (minIndex != i) {
				temp = seq[i];
				seq[i] = seq[minIndex];
				seq[minIndex] = temp;
			}
		}
	}
}