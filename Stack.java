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

    public void push (int number) {
        Node newNode = new Node(number, top);

        top = newNode;

        size++;     
    }

    public int pop () {
        int i;

        i = top.getData();
        top = top.getNext();

        size--;

        return i;
    }

    public int ontop() {
        int i = pop();

        push(i);

        return i;
    }

    public int size() {
        return size;
    }
}