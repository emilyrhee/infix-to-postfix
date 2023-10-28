class Node {
    private int data;
    private Node next;

    public Node(int d) {
        data = d;
    }
    
    public Node(int d, Node n) {
        data = d;
        next = n;
    }
    
    public void setData(int newData) {
        data = newData;
    }
    
    public void setNext(Node newNext) {
        next = newNext;
    }
    
    public int getData() {
        return data;
    }
    
    public Node getNext() {
       return next;
    }
    
    public void printNodeData() {
       System.out.println(data);
    }
 }