public class Queue<T> {
    private int size;
    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null);

        if (this.empty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }

        rear = newNode;
        size++;
    }

    public T dequeue() {
        T dequeued = front.getData();
        front = front.getNext();
        size--;

        if (this.empty()) {
            rear = null;
        }

        return dequeued;
    }

    public T getFront() {
        return front.getData();
    }

    public T getRear() {
        return rear.getData();
    }

    public void printQueue() {
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }   
}
