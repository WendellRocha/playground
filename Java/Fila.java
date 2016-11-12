public class Fila {

    private int[] fila;
    private int capacidade, head, tail;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
        this.fila = new int[capacidade];
    }

    public boolean isEmpty() {
        return (this.head == -1 && this.tail == -1);
    }

    public boolean isFull() {
        return ((this.tail + 1) % capacidade) == this.head; 
    }

    public void add(int n) {

        if (isFull()) throw new RuntimeException("Is Full");
        if (isEmpty()) {
            this.head = 0;
            this.tail = 0;
            this.fila[0] = n;
        } else {
                tail = (tail + 1) % capacidade;
                this.fila[tail] = n;
        }

    }

    public int remove() {
        
        if (isEmpty())
            throw new RuntimeException("QueuIsEmptyException");

        int value = fila[head];
        
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = ((this.head + 1) % capacidade);
        }
        return value; 
        
    }

    public int head() {
        if (this.isEmpty())
            throw new RuntimeException("QueuIsEmptyException");
        return this.fila[head];
    }    

    public static void main(String[] args) {
        Fila fila = new Fila(10);
        assert fila.isEmpty();
        fila.add(2);
        fila.add(5);
        fila.add(7);
        assert fila.head() == 2;
        assert fila.remove() == 2;
        assert fila.head() == 5;
        fila.add(3);
        fila.add(1);
        fila.add(10);
        fila.add(9);
        fila.add(4);
        fila.add(6);
        
        assert fila.remove() == 5;
        assert fila.head() == 7;

        fila.add(2);
        assert !fila.isFull();

        fila.add(14);
        fila.add(29);
        assert fila.isFull();
    }
}
