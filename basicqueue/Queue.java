package basicqueue;

public class Queue {
	private Object arrai[];
	private int size;
	private int start;
	private int end;
	
	public Queue(int size) {
		this.size = size;
		arrai = new Object[size];
		start = 0;
		end = 0;
	}
	
	public void mimDaAQueueMano() {
		System.out.printf("[ ");
		for(int i=0; i<size; i++ ) {
			if (i==size-1) {
				System.out.printf("%s ", arrai[i]);
			}else {
				System.out.printf("%s, ", arrai[i]);
			}
		}
		System.out.printf("], tamanho %d ", size());
		if (isEmpty()) System.out.printf("e está vazia%n"); else System.out.printf("%n");
	}
	
	public void enqueue(Object x) {
		if (this.size() == size-1) {
			System.out.println("DEBUGA ESSE RAIO");
			Object aux[] = new Object[size*2];
			for (int i=0; i<size; i++) {
				aux[i] = arrai[i];
			}
			arrai = aux;
			size *=2;
		}
		// TEM QUE PASSAR UM NOVO START DUMA FORMA MELHOR AAHAHAHAHA
		// TEM QUE LEMBRAR QUE O START MUDA DE LUGAR (A LINHA ABAIXO SERVE PRA JOGAR O FIM DA FILA PRO INÍCIO PRA FAZER O ARRAY CIRCULAR)
		// situação: o array circula com elementos dequeados (o start já não é mais no início do arr). Como prosseguir?
		if (end == size) end = start;
		arrai[end] = x;
		end++;
	}
	
	public Object dequeue() {
		start++;
		return arrai[end-1];
	}
	
	public Object first() {
		return arrai[start];
	}
	
	public int size() {
		return (size-start+end) % size;
	}
	
	public boolean isEmpty() {
		return (start == end);
	}
	
	
}
