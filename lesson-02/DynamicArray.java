import java.util.Comparator;
import java.util.Iterator;

public class DynamicArray<Item> {

    private static final int NOT_FOUND = -1;
    private static final int LENGTH = 100;

    private Object[] data;
    private int count = 0;

    // Зарезервировать массив под стандартное количество элементов
    public DynamicArray() {
        data = new Object[LENGTH];
    }

    // Зарезервировать массив для определенного числа элементов
    public DynamicArray(int capacity) {
        data = new Object[capacity];
    }

    // Возвращает элемент по индексу
    public Item get(int index) {
        return isCorrect(index) ? (Item)data[index]: null;
    }

    // Проверяет корректность индекса
    private boolean isCorrect(int index) {
        return index >= 0 && index < count;
    }

    // Установить значение массива на позиции index
    public boolean set(int index, Item value) {
        if (!isCorrect(index))
            return false;

        data[index] = value;
        return true;
    }

    // Добавляет элемент массив
    public boolean add(Item value) {
        if (count == data.length) // если заполнен, расширить в 2 раза
            resize(2);

        data[count] = value;
        count++;
        return true;
    }

    // Операция удаления элемента по индексу - базовая операция удаления
    public boolean removeAt(int index) {
        if (!isCorrect(index)) // аналогичным образом проверяет корректность индекса
            return false;

        set(index, null);
        leftShift(index);
        count--;

        if (count <= (int)(0.25 * capacity())) // освободить лишнюю память: если массив заполнен на четверть - уменьшить вдвое
            resize(0.50);
        return true;
    }

    // Удалить элемент по значению (первое совпадение слева)
    public boolean removeByValue(Item value) {
        int index = indexOf(value);
        if (index == NOT_FOUND)
            return false;
        return removeAt(index);
    }

    // Удалить последний элемент
    public boolean remove() {
        int last = count - 1; // можно было бы проверить на ненулевое количество элементов, но тогда проверка будет осуществляться дважды
        return removeAt(last); // функция уже реализована, учитывая и допустимость операции
    }

    // Изменить размерность массива в k раз (увеличение при k > 1, уменьшение при 0 < k < 1)
    private void resize(double k) {
        // Создается новый массив и в него перемещаются все прежние элементы
        int newSize = (int)(k * capacity());
        Object[] target = new Object[newSize];
        for (int i = 0; i < count; i++)
            target[i] =  this.data[i];
        this.data = target;
    }

    // Линейный поиск элемента в массиве
    public int indexOf(Item value) {
        for (int i = 0; i < count; i++)
            if (get(i).equals(value)) return i;
        return NOT_FOUND;
    }

    // Проверить наличие значения (элемента) в массиве
    public boolean contains(Item value) {
        return indexOf(value) != NOT_FOUND;
    }

    // Вспомогательная функция - осуществляет сдвиг элементов массива влево начиная с позиции point
    private void leftShift(int point) {
        for (int i = point; i < count - 1; i++)
            data[i] = data[i + 1];
    }

    // Вывод на экран
    public void display() {
        System.out.print('[' );
        for (int i = 0; i < count - 1; i++)
            System.out.print(data[i] + ", ");
        System.out.println(data[count - 1].toString() +  ']');
    }

    // Количество элементов в массиве по факту
    public int size() {
        return count;
    }

    // Количество зарезервированных под массив элементов
    // Формальной необходимости в этой функции нет, нужна только для теста/проверки на динамическое изменение размерности массива
    public int capacity() {
        return data.length; // Однако, удобно применять в целях самого же массива - capacity прозрачнее, чем data.length
    }

    public void selectionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size(); j++)
                if (cmp.compare(get(j), get(min)) < 0) min = j; // если использовать get() то приводить к типу Item - не требуется (магия, не иначе)
            Item temp = get(i); set(i, get(min)); set(min, temp); // swap(min, i)
        }
    }

    public void insertionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size(); i++)
            for (int j = i; j > 0; j--)
                if (cmp.compare(get(j), get(j - 1)) < 0) {
                    Item tmp = get(j); set(j, get(j - 1)); set(j - 1, tmp); // swap(j, j - 1)
                } else
                    break;
    }

    public void bubbleSort(Comparator<Item> cmp) {
        for (int i = 0; i < size(); i++)
            for (int j = 0; j < size() - 1 - i; j++)
                if (cmp.compare(get(j + 1), get(j)) < 0) {
                    Item tmp = get(j); set(j, get(j + 1)); set(j + 1, tmp);
                }
    }
}
