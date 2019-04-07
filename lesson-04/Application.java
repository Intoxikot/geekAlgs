
public class Application {

    // Тесты и проверка методов связного списка
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        System.out.println('\t' + "test #1: add first/last");
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(15);
        list.addFirst(16);
        list.addFirst(17);
        list.addFirst(18);

        list.addLast(12);
        list.addLast(11);
        list.addLast(10);

        System.out.println(list);
        System.out.println("removed: " + list.removeFirst()); // 18
        System.out.println(list);
        System.out.println("removed: " + list.removeFirst()); // 17
        System.out.println(list);
        System.out.println("peek: " + list.getFirst());    // 16
        System.out.println();
    }

    public static void test2() {
        System.out.println('\t' + "test #2: add/remove by index");
        LinkedList<Integer> list = new LinkedList<>();

        list.add(0, 10);
        System.out.println(list);
        list.add(1, 14);
        System.out.println(list);
        list.add(1, 12);
        System.out.println(list);
        list.add(1, 11);
        System.out.println(list);
        list.add(3, 13);

        System.out.println(list);
        list.removeAt(1);
        System.out.println(list);
        list.removeAt(2);
        System.out.println(list);
        list.removeAt(1);
        System.out.println(list);
        list.removeAt(1);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        System.out.println();
    }

    public static void test3() {
        System.out.println('\t' + "test #3: search");
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(12);
        list.addLast(13);
        list.addLast(14);
        list.addLast(15);
        list.addLast(16);

        System.out.println(list);
        System.out.println(list.indexOf(15));   // 3
        System.out.println(list.indexOf(8));    // -1
        System.out.println(list.contains(14));  // true
        System.out.println(list.contains(18));  // false
        System.out.println();
    }
}
