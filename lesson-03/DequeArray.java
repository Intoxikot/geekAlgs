import java.util.NoSuchElementException;

public class DequeArray<Item>  {

    Object[] data; // данные
    int count = 0; // количество элементов в счереди
    int capacity; // максимальный размер очереди

    int head = -1; // голова - начало очереди
    int tail = -1; // хвост - конец очереди

    private static final int LENGTH = 100;

    // Инициализация стандартного размера
    public DequeArray() {
        data = new Object[LENGTH];
        this.capacity = LENGTH;
    }

    // Инициализация с резервированием памяти
    public DequeArray(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    // Добавление элементов и удаление - как показала практика, здесь очень важен точный порядок действий, любое его нарушение ведет к ошибкам
    // Основной принцип в том, что очень важно точно представлять, как мы используем указатели. Либо они указывают на новые - пустые ячейки, либо на ячейки со значением
    // Верный вариант - это со значением, т.к. делает чтение элементов естественным (не нужны никакие циклические сдвиги и проверки)

    // Добавить элемент в начало
    public void pushFront(Item value) {
        head = leftShift(head); // вспомогательная функция сдвига - решает вопрос циклического сдвига значений и позволяет не путаться в методах
        data[head] = value;
        count++;
        checkIncrease();
    }

    // Добавить элемент в конец
    public void pushLast(Item value) {
        tail = rightShift(tail);
        data[tail] = value;
        count++;
        checkIncrease();
    }

    // Извлечь с начала
    public Item popFront() {
        checkEmpty();
        Item value = (Item) data[head];
        head = rightShift(head);
        count--;
        checkDecrease();
        return value;
    }

    // Извлечь с конца
    public Item popLast() {
        checkEmpty();
        Item value = (Item) data[tail];
        tail = leftShift(tail);
        count--;
        checkDecrease();
        return value;
    }

    // Прочесть первый элемент
    public Item peekFront() {
        checkEmpty();
        return (Item) data[head];
    }

    // Прочесть последний элемент
    public Item peekLast() {
        checkEmpty();
        return (Item) data[tail];
    }

    // Пуст?
    public boolean isEmpty() {
        return count == 0;
    }

    // Количество элементов
    public int size() {
        return count;
    }

    // Проверка на допустимость чтения/извлечения элемента
    private void checkEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Error: deque is empty");
    }

    // Проверка на увеличение размера
    private void checkIncrease() {
        if (count == capacity) // head == tail
            resize(capacity * 2);
    }

    // Проверка на уменьшение размера
    private void checkDecrease() {
        if (count < capacity / 4 && count > 0)
            resize(capacity / 4);
    }

    // Вспомогательные функции циклического сдвига - снимает эту задачу с методов вставки/удаления и повышает читабельность
    // Циклический сдвиг вправо
    private int rightShift(int position) {
        position++;
        position %= capacity;
        return position;
    }

    // Цикличекий сдвиг влево
    private int leftShift(int position) {
        position--;
        if (position < 0) position = capacity - 1; // если вышел за левую границу, значит осуществляем перенос на правую границу
        return position;
    }

    // Изменить размер очереди
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; i++) {
            int pos = (head + i) % capacity;
            temp[i] = data[pos];
        }
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
            return "deque : { empty }";

        StringBuilder out = new StringBuilder();
        out.append("deque : { ");
        for (int i = 0; i < count; i++) {
            int pos = (head + i) % capacity;
            out.append(data[pos] + " ");
        }
        out.append("}");
        return out.toString();
    }
}