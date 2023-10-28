class Stack {
    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean empty() {
        return (top == null);
    }

    public void push(String data) {
        Node newNode = new Node(data, top);

        top = newNode;

        size++;     
    }

    public String pop() {
        String i;

        i = top.getData();
        top = top.getNext();

        size--;

        return i;
    }

    public String ontop() {
        String i = pop();

        push(i);

        return i;
    }

    public int size() {
        return size;
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }    
}