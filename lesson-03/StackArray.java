import java.util.NoSuchElementException;

public class StackArray<Item>  {

    Object[] data; // данные
    int count = 0; // количество элементов в стеке
    int capacity; // максимальный размер стека

    private static final int LENGTH = 100;

    // Инициализация стандартного размера
    public StackArray() {
        data = new Object[LENGTH];
        this.capacity = LENGTH;
    }

    // Инициализация с резервированием памяти
    public StackArray(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    // Добавить элемент
    public void push(Item value) {
        data[count++] = value;
        if (count == capacity)
            resize(capacity * 2);
    }

    // Чтение с извлечением элемента
    public Item pop() {
        checkEmpty();
        if (count < capacity / 4 && count > 0)
            resize(capacity / 4);
        return (Item) data[count-- - 1];
    }

    // Прочесть последний элемент
    public Item peek() {
        checkEmpty();
        return (Item) data[count - 1];
    }

    // Пуст?
    public boolean isEmpty() {
        return count == 0;
    }

    // Количество элементов в стеке
    public int size() {
        return count;
    }

    // Проверка на допустимость чтения/извлечения элемента
    private void checkEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Error: stack is empty");
    }

    // Изменить размер стека
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; i++)
            temp[i] = data[i];
        data = temp;
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
            return "stack : { empty }";

        StringBuilder out = new StringBuilder();
        out.append("stack : { ");
        for (int i = 0; i < count; i++)
            out.append(data[i] + " ");
        out.append("}");
        return out.toString();
    }
}