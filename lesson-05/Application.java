
import java.util.LinkedList;
import java.util.List;

// Учитыая, что задание весьма тривиальное (даже для рекурсии), то просто решить задачу было бы недостаточно
// Проявим творческую мысль и кодоблудие
public class Application {

    // Класс представляет данные для тестов
    // Предполагается, что мы будем тестировать множество методов на одинаковых наборах данных
    private static class powPair {
        float value;    // исходное значение
        int range;      // степень
        float result;   // ожидаемый результат

        public powPair(float value, int range, float result) {
            this.value = value;
            this.range = range;
            this.result = result;
        }
    }

    // Преполагаем, что методов может быть сколь угодно много
    private enum MethodType{CYCLE, RECUR};

    public static void main(String[] args) {
        List<powPair> input = getInputValues();
        test(input, MethodType.CYCLE);
        test(input, MethodType.RECUR);
    }

    // Входной набор данных для тестов
    // (если мы предполагаем несколько различных наборов: то либо используем разные методы, либо используем один со свичем)
    public static List<powPair> getInputValues() {
        List<powPair> list = new LinkedList<powPair>();
        list.add(new powPair(1, 3, 1));
        list.add(new powPair(2, 1, 2));
        list.add(new powPair(2, 0, 1));
        list.add(new powPair(2, 3, 8));

        list.add(new powPair(2, -1, 0.50f));
        list.add(new powPair(2, -2, 0.25f));
        list.add(new powPair(3, 3, 27));
        list.add(new powPair(-3, 3, -27));
        list.add(new powPair(-3, 2, 9));
        return list;
    }

    // Базовый тест может вызываться с различными входными данными и проверять различные методы
    public static void test(List<powPair> in, MethodType method) {
        System.out.println('\t' + "test 1: cycle pow");
        for (powPair pp : in) {
            float result = 0.0000f;
            // а ошибку придется отлавливать
            try { result = getResult(pp, method); } catch (NoSuchMethodException e) { System.out.println(e.getMessage()); }
            String answer = (result == pp.result) ? "(correct)": "<<< wrong >>>"; // если полученный результат совпадает с ожидаемым, то выводится соответствующее сообщение
            System.out.println(result + " " + answer);
        }
        System.out.println();
    }

    // Вызывает требуемый метод, при необходимости добавляем в набор
    public static float getResult(powPair data, MethodType method) throws NoSuchMethodException {
        switch (method) {
            case CYCLE: return pow(data.value, data.range);
            case RECUR: return rpow(data.value, data.range);
            default: throw new NoSuchMethodException("method " + method.name().toString() + " doesnt exist"); // если метода нет в наборе - генерируем самую страшную и ужасную ошибку
        }
    }

    // Циклическое возведение в степень
    public static float pow(float x, int n) {
        float product = 1.00f;
        for (int i = 0; i < Math.abs(n); i++)
            product *= x;
        if (n < 0)
            product = 1 / product;
        return product;
    }

    // Рекурсивное возведение в степень
    public static float rpow(float x, int n) {
        if (n == 0) // условия завершения, выхода из рекурсии
             return 1;
        if (n == 1)
            return x;

        if (n < 0) // можно испольщовать тернарный оператор в выражении, но это не очень удобно для восприятия
            x = 1 / x;

        return rpow(x, Math.abs(n) - 1) * x; // тело рекурсии
    }
}