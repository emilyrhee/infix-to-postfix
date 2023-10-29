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
        String infixExp = "13 + 5"; // elements must be separated by space

        String[] infixArray = infixExp.split(" ");

        Queue infixQueue = new Queue();
        Stack operators = new Stack();
        Queue postfixQueue = new Queue();

        for (int i = 0; i < infixArray.length; i++) {
            infixQueue.enqueue(infixArray[i]);
        }

        for (int i = 0; i < 3; i++) {
            if (priority(infixQueue.getFront()) == 0) {
                postfixQueue.enqueue(infixQueue.dequeue());
            } else {
                operators.push(infixQueue.dequeue());
            }
        }
        
        System.out.println("Infix expression: " + infixExp);
        //System.out.println("Postfix expression: ");
    }
}