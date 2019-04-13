import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements ExtendedList<Item>, Iterable<Item> {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    private final int NOT_FOUND = -1;

    private class Node {
        Item value;
        Node next = null;
        Node prev = null;

        public Node(Item value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private class ListIterator implements Iterator<Item> {
        Node cursor = first;

        @Override public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Item value = cursor.value;
            cursor = cursor.next;
            return value;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    @Override
    public void addFirst(Item value) {
        Node early = first;
        first = new Node(value, null, early);
        if (isEmpty())
            last = first;
        else
           early.prev = first;
        size++;
    }

    @Override
    public Item removeFirst() {
        checkEmpty();

        Item value = first.value;
        if (size != 1)
            first = first.next;
        else
            resetPointers();
        size--;
        return value;
    }

    @Override
    public Item getFirst() {
        checkEmpty();
        return first.value;
    }

    @Override
    public void addLast(Item value) {
        Node early = last;
        last = new Node(value, early, null);
        if (isEmpty())
            first = last;
        else
            early.next = last;
        size++;
    }

    @Override
    public Item removeLast() {
        checkEmpty();

        Item value = last.value;
        Node previous = last.prev;
        last.prev = null;
        last = previous;
        size--;

        if (isEmpty())
            first = null;
        else
            last.next = null;
        return value;
    }

    @Override
    public Item getLast() {
        checkEmpty();
        return last.value;
    }

    @Override
    public void add(int index, Item value) {
        if (index == firstIndex())
            addFirst(value);
        else if (index == newIndex())
            addLast(value);
        else
            addToMiddle(index, value);
    }

    @Override
    public void set(int index, Item value) {
        Node current = getNode(index);
        current.value = value;
    }

    @Override
    public Item get(int index) {
        Node current = getNode(index);
        return current.value;
    }

    @Override
    public Item remove(Item value) {
        int index = indexOf(value);
        if (index == NOT_FOUND)
            throw new NoSuchElementException("item doesn't exist in list");
        return removeAt(index);
    }

    @Override
    public Item removeAt(int index) {
        if (index == firstIndex())
            return removeFirst();
        else if (index == lastIndex())
            return removeLast();
        else
            return removeFromMiddle(index);
    }

    @Override
    public int indexOf(Item value) {
        if (isEmpty())
            return NOT_FOUND;

        ListIterator it = new ListIterator();
        for (int i = 0; i < size; i++, it.next())
            if (it.cursor.value.equals(value))
                return i;
        return NOT_FOUND;
    }

    @Override
    public boolean contains(Item value) {
        return indexOf(value) != NOT_FOUND;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "linkedlist: { empty }";

        StringBuffer out = new StringBuffer();
        out.append("linkedlist: { ");
        for (Item value: this)
            out.append(value + " ");
        out.append("}");
        return out.toString();
    }

    private void checkEmpty() {
        if (isEmpty())
            throw new NoSuchElementException("list is empty - contains no items");
    }

    private int lastIndex() {
        return size - 1;
    }

    private int firstIndex() {
        return 0;
    }

    private int newIndex() {
        return size;
    }

    private void resetPointers() {
        first = null;
        last = null;
    }

    // Проверяет корректность индекса
    private void checkIndex(int index) {
        if (!(index > 0 && index < size)) // проверять на isEmpty() не требуется
            throw new NoSuchElementException("required index doesn't exist");
    }

    // Возвращает узел по индексу
    private Node getNode(int index) {
        checkIndex(index);
        Node current = first;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    // Осуществляет вставку в середину списка (если индекс не последний и не первый)
    private void addToMiddle(int index, Item value) {
        Node current = getNode(index);
        Node previous = current.prev;

        Node item = new Node(value, previous, current);

        previous.next = item;
        current.prev = item;
        size++;
    }

    // Удаление с середины
    private Item removeFromMiddle(int index) {
        Node current = getNode(index);
        Node previous = current.prev;
        Node next = current.next;

        if (previous != null) previous.next = next; // при небольшом размере списка мы все равно выходим за пределы и натыкаемся на null
        if (next != null) next.prev = previous;

        size--;
        return current.value;
    }
}