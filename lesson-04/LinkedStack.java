
// Чтобы получить стек из очереди достаточно переопределить добавление, все остальные методы без изменений
public class LinkedStack<Item> extends LinkedQueue<Item> implements QueueInterface<Item> {

    ExtendedList<Item> list = new LinkedList<>();
    public LinkedStack() { }

    @Override public void push(Item value)   { list.addFirst(value); }
}
