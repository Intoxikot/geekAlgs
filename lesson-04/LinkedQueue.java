
public class LinkedQueue<Item> implements QueueInterface<Item> {

    ExtendedList<Item> list = new LinkedList<>();
    public LinkedQueue() { }

    @Override public void push(Item value)   { list.addLast(value); }
    @Override public Item pop()              { return list.removeFirst(); }
    @Override public Item peek()             { return list.getFirst(); }
    @Override public boolean isEmpty()       { return list.isEmpty(); }
    @Override public int size()              { return list.size(); }
}