import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String infixExp = "13 + 5"; // elements must be separated by space

        String[] infixArray = infixExp.split(" ");

        Queue infixQueue = new Queue();

        for (int i = 0; i < infixArray.length; i++) {
            infixQueue.enqueue(infixArray[i]);
        }

        System.out.println("Infix expression: " + infixExp);
        //System.out.println("Postfix expression: ");
    }
}