import java.util.Comparator;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    public static void test4() {
        System.out.println('\t' + "test #4: insertion sort test");
        DynamicArray a = generateArray(100);
        a.display();
        a.insertionSort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        a.display();
        System.out.println();
    }

    public static void test5() {
        System.out.println('\t' + "test #5: selection sort test");
        DynamicArray a = generateArray(100);
        a.display();
        a.selectionSort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        a.display();
        System.out.println();
    }

    public static void test6() {
        System.out.println('\t' + "test #6: bubble sort test");
        DynamicArray a = generateArray(100);
        a.display();
        a.bubbleSort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        a.display();
        System.out.println();
    }

    // Генератор для массива
    public static DynamicArray generateArray(int size) {
        Random rand = new Random();
        DynamicArray<Integer> list = new DynamicArray<>(size);
        for (int i = 0; i < size; i++)
            list.add(rand.nextInt(100));
        return list;
    }

    public static double getAverage(double[] results) {
        double sum = 0;
        int count = results.length;
        for (int i = 0; i < count; i++)
            sum += results[i];
        return sum / count;
    }

    // Тест поиска в массиве
    public static void test1() {
        System.out.println('\t' + "test #1: search/remove");
        DynamicArray<Integer> list = new DynamicArray<>(10);
        list.add(10);
        list.add(4);
        list.add(15);
        list.add(8);
        list.add(19);
        list.display();

        System.out.println("list.contains(15) = "  + list.contains(15)); // true
        System.out.println("list.contains(14) = " + list.contains(14)); // false

        System.out.println("list.indexOf(15) = " + list.indexOf(15)); // 2
        System.out.println("list.indexOf(15) = " + list.indexOf(14)); // -1

        list.removeByValue(8); System.out.println("list.removeByValue(8)");
        list.removeByValue(4); System.out.println("list.removeByValue(4)");
        list.display();
        list.removeAt(1); System.out.println("list.removeAt(1)");
        list.display();
        System.out.println();
    }

    // Тест на расширение
    public static void test2() {
        System.out.println('\t' + "test #2: expand");
        DynamicArray<Integer> list = new DynamicArray<>(10);
        for (int i = 0; i < 20; i++) {
            list.add(i * 2);
            list.display();
            System.out.println("capacity = " + list.capacity() + ", size = " + list.size());
            System.out.println();
        }
    }

    // Тест на сужение
    public static void test3() {
        System.out.println('\t' + "test #2: reduce");
        DynamicArray<Integer> list = new DynamicArray<>(100);
        for (int i = 0; i < 50; i++)
            list.add(i * 2);

        for (int i = 0; i < 50; i++) {
            list.display();
            System.out.println("capacity = " + list.capacity() + ", size = " + list.size());
            list.remove();
            System.out.println();
        }

    }
}
