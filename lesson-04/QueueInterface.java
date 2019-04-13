
// Базовый интерфейс для стека/очереди
public interface QueueInterface<Item> {
    void push(Item value);
    Item pop();
    Item peek();
    boolean isEmpty();
    int size();
}
