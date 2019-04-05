import java.util.NoSuchElementException;

public class QueueArray<Item>  {

    Object[] data; // данные
    int count = 0; // количество элементов в счереди
    int capacity; // максимальный размер очереди

    int head = 0; // голова - начало очереди
    int tail = 0; // хвост - конец очереди

    private static final int LENGTH = 100;

    // Инициализация стандартного размера
    public QueueArray() {
        data = new Object[LENGTH];
        this.capacity = LENGTH;
    }

    // Инициализация с резервированием памяти
    public QueueArray(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    // Добавить элемент
    public void push(Item value) {
        data[tail++] = value;
        tail %= capacity;
        count++;
        if (count == capacity) // head == tail
            resize(capacity * 2);
    }

    // Чтение с извлечением элемента
    public Item pop() {
        checkEmpty();
        if (count < capacity / 4 && count > 0)
            resize(capacity / 4);
        count--;
        Item value = (Item) data[head++];
        head %= capacity;
        return value;
    }

    // Прочесть первый элемент
    public Item peek() {
        checkEmpty();
        return (Item) data[head];
    }

    // Очередь пуста?
    public boolean isEmpty() {
        return count == 0;
    }

    // Количество элементов в очереди
    public int size() {
        return count;
    }

    // Проверка на допустимость чтения/извлечения элемента
    private void checkEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Error: queue is empty");
    }

    // Изменить размер очереди
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; i++) {
            int pos = (head + i) % capacity;
            temp[i] = data[pos];
        };
        data = temp;
        capacity = size;
        head = 0;
        tail = count;
    }

    // Вывод на экран всех элементов
    public void display() {
        System.out.println(this.toString());
    }

    // Получить размерность
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "queue : { empty }";

        StringBuilder out = new StringBuilder();
        out.append("queue : { ");
        for (int i = 0; i < count; i++) {
            int pos = (head + i) % capacity;
            out.append(data[pos] + " ");
        }
        out.append("}");
        return out.toString();
    }
}