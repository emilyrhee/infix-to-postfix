public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean empty() {
        return (top == null);
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data, top);
        top = newNode;
        size++;     
    }

    public T pop() {
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T ontop() {
        return top.getData();
    }

    public int size() {
        return size;
    }

    public void printStack() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }    
}