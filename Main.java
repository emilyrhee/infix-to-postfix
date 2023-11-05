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

    static boolean isOperator(Queue<String> s) {
        return (priority(s.getFront()) > 0);
    }

    static boolean stringsAreEqual(Queue<String> q, String s) {
        return q.getFront().equals(s);
    }

    static Queue<String> infixToPostfix(String s) {
        String[] infixArray = s.split(" ");

        Queue<String> infixQueue = new Queue<>();
        Stack<String> operators = new Stack<>();
        Queue<String> postfixQueue = new Queue<>();

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
    
    static int evaluatePostfix(Queue<String> postfix) {
        Stack<Integer> values = new Stack<>();

        while (!postfix.empty()) {
            if (!isOperator(postfix)) {
                values.push(Integer.parseInt(postfix.dequeue()));
            } else {
                int value1 = values.pop();
                int value2 = values.pop();

                switch (postfix.dequeue()) {
                    case "+":
                        values.push(value1 + value2);
                        break;
                    case "-":
                        values.push(value2 - value1);
                        break;
                    case "/":
                        values.push(value2 / value1);
                        break;
                    case "*":
                        values.push(value2 * value1);
                        break;
                }
            }
        }

        return values.ontop();
    }

    public static void main(String[] args) {
        String infixExp = "( 4 - 2 ) * 4 - 5 / 3"; // elements must be separated by space

        System.out.println("Infix: " + infixExp);

        Queue<String> postfix = infixToPostfix(infixExp);

        System.out.print("Postfix: ");
        postfix.printQueue();

        System.out.println("Evaluation: " + evaluatePostfix(postfix));
    }
}