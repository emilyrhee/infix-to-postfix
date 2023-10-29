import java.util.Arrays;

class Main {
    static int priority(String s) {
        switch (s) {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String infixExp = "1 + 2 * 3 + 4"; // elements must be separated by space

        String[] infixArray = infixExp.split(" ");

        Queue infixQueue = new Queue();
        Stack operators = new Stack();
        Queue postfixQueue = new Queue();

        for (int i = 0; i < infixArray.length; i++) {
            infixQueue.enqueue(infixArray[i]);
        }

        for (int i = 0; i < infixArray.length; i++) {
            if (priority(infixQueue.getFront()) > 0) {
                while (!operators.empty() && priority(operators.ontop()) >= priority(infixQueue.getFront())) {
                    postfixQueue.enqueue(operators.pop());
                }

                operators.push(infixQueue.dequeue());
            } else {
                postfixQueue.enqueue(infixQueue.dequeue());
            }
        }

        while (!operators.empty()) {
            postfixQueue.enqueue(operators.pop());
        }

        System.out.println("Infix: " + infixExp);

        System.out.print("Postfix: "); 
        postfixQueue.printQueue();
    }
}