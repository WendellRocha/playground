import java.util.Arrays;

public class Heap {
	
	private int[] heap;
	private int tail;
	
	public Heap(int capacidade) {
		this.heap = new int[capacidade];
		this.tail = -1;
	}

	public int left(int i) {
		return 2*i+1;
	}

	public int right(int i) {
		return (i+1)*2;
	}

	public int parent(int i) {
		return (i-1)/2;
	}

	public void add(int n) {
		
		if (tail < (heap.length - 1)) {
			
			tail += 1;
			this.heap[tail] = n;
			
			int i = tail;
			while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
				int aux = this.heap[i];
				this.heap[i] = this.heap[parent(i)];
				this.heap[parent(i)] = aux;
				i = parent(i);
			}
		
		}
		
	}
	
	public String toString() {
		return Arrays.toString(this.heap);
	}
	
}
