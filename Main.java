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

    static boolean isOperator(Queue s) {
        if (priority(s.getFront()) > 0) {
            return true;
        } else return false;
    }

    static boolean stringsAreEqual(Queue q, String s) {
        return q.getFront().equals(s);
    }

    static Queue infixToPostfix(String s) {
        String[] infixArray = s.split(" ");

        Queue infixQueue = new Queue();
        Stack operators = new Stack();
        Queue postfixQueue = new Queue();

        for (int i = 0; i < infixArray.length; i++) {
            infixQueue.enqueue(infixArray[i]);
        }

        for (int i = 0; i < infixArray.length; i++) {
            if (isOperator(infixQueue)) {
                while (!operators.empty() && priority(operators.ontop()) >= priority(infixQueue.getFront())) {
                    postfixQueue.enqueue(operators.pop());
                }

                operators.push(infixQueue.dequeue());
            } else if (stringsAreEqual(infixQueue, "(")) {
                operators.push(infixQueue.dequeue());
            } else if (stringsAreEqual(infixQueue, ")")) {
                infixQueue.dequeue();

                String x = operators.pop();

                while (!x.equals("(")) {
                    postfixQueue.enqueue(x);
                    x = operators.pop();
                }
            } else {
                postfixQueue.enqueue(infixQueue.dequeue());
            }
        }

        while (!operators.empty()) {
            postfixQueue.enqueue(operators.pop());
        }

        return postfixQueue;
    }
    
    static int evaluatePostfix(Queue postfix) {
        Stack operators = new Stack();
        Stack values = new Stack();

        while (!postfix.empty()) {
            if (isOperator(postfix)) {
                operators.push(postfix.dequeue());
            } else {
                values.push(postfix.dequeue());
            }
        }

        return 2;
    }

    public static void main(String[] args) {
        String infixExp = "3 + 5 * 2 - ( 4 / 2 )"; // elements must be separated by space

        System.out.println("Infix: " + infixExp);

        Queue postfix = infixToPostfix(infixExp);

        System.out.print("Postfix: ");
        postfix.printQueue();

        System.out.println("Evaluation: " + evaluatePostfix(postfix));
    }
}