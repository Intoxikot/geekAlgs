
public class App {

    public static void main(String[] args) {
        testStack();
        testQueue();
        // testDeque();
        reverseString("you shall not pass");
    }

    public static void testStack() {
        System.out.println('\t' + "Stack-test:");
        StackArray<Integer> myStack = new StackArray<>(10);

        System.out.println(myStack);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.size());

        for (int i = 0; i < 5; i++)
            myStack.push(i+1);

        System.out.println(myStack);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.size());

        for (int i = 1; i <= 5; i++)
            System.out.println(myStack.pop());
        System.out.println();
    }

    public static void testQueue() {
        System.out.println('\t' + "Queue-test:");
        QueueArray<Integer> myQueue = new QueueArray<>(5);

        System.out.println(myQueue);
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.size());

        for (int i = 0; i < 10; i++)
            myQueue.push(i); // Заполняем чем-нибудь

        System.out.println(myQueue);
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.size());

        for (int i = 0; i < 7; i++)
            myQueue.pop();

        for (int i = 0; i < 5; i++) {
            myQueue.push(i + 10);
            myQueue.pop();
            System.out.println(myQueue);
        }
        System.out.println();
    }

    public static void reverseString(String text) {
        System.out.println('\t' + "Reverse string:");
        System.out.println(text);
        StackArray<Character> stack = new StackArray<>(text.length());
        for (int i = 0; i < text.length(); i++)
            stack.push(text.charAt(i));
        for (int i = 0; i < text.length(); i++)
            System.out.print(stack.pop());
    }
}
