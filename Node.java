public class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
        this(null, null);
    }

    public Node(T d) {
        data = d;
        next = null;
    }
    
    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }
    
    public void setData(T newData) {
        data = newData;
    }
    
    public void setNext(Node<T> newNext) {
        next = newNext;
    }
    
    public T getData() {
        return data;
    }
    
    public Node<T> getNext() {
       return next;
    }
    
    public void printNodeData() {
       System.out.println(data);
    }
}