
// Расширенный интерфейс для списка - может быть использован как дека, очередь или стек
public interface ExtendedList<Item> {
    void addFirst(Item value);
    Item removeFirst();
    Item getFirst();

    void addLast(Item value);
    Item removeLast();
    Item getLast();

    void add(int index, Item value);
    void set(int index, Item value);
    Item get(int index);

    Item remove(Item value);
    Item removeAt(int index);

    int indexOf(Item value);
    boolean contains(Item value);
    boolean isEmpty();
    int size();
}