class Queue{
	private int size;
	private Node front;
	private Node rear;
 
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

	public void enqueue(String data) {
     	Node newNode = new Node(data, null);

     	if (this.empty()) {
       		front = newNode;
		} else {
    		rear.setNext(newNode);
		}

     	rear = newNode;
     	size++;
   	}

   	public String dequeue() {
     	String dequeued;

     	dequeued = front.getData();
     	front = front.getNext();

     	size--;

     	if (this.empty()) 
        	rear = null;

     	return dequeued;
   	}

   	public String getFront() {
     	return front.getData();
   	}

	public String getRear() {
		return rear.getData();
	}

	public void printQueue() {
		Node current = front;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		System.out.println();
	}	
}