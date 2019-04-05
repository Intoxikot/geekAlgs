
public class App {

    public static void main(String[] args) {
        testStack();
        testQueue();
        testDeque();
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

    public static void testDeque() {
        System.out.println('\t' + "Deque-test:");
        DequeArray<Integer> myDeque = new DequeArray<>();

        System.out.println(myDeque);
        System.out.println(myDeque.isEmpty());
        System.out.println(myDeque.size());

        myDeque.pushFront(3);
        myDeque.pushFront(2);
        myDeque.pushFront(1);
        System.out.println(myDeque);

        myDeque.pushLast(4);
        myDeque.pushLast(5);
        myDeque.pushLast(6);
        System.out.println(myDeque);

        System.out.println(myDeque.popLast());
        System.out.println(myDeque.popFront());
        System.out.println(myDeque);

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
