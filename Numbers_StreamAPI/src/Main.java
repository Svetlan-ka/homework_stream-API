import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> listRemove = new ArrayList<>();
        List<Integer> listEvenNumbers = new ArrayList<>();

        // удаление отрицательных чисел из списка
        for (int number : list) {
            if (number > 0) {
                listRemove.add(number);
            }
        }

        // фильтрация четных чисел
        for (int number : listRemove) {
            if (number % 2 == 0) {
                listEvenNumbers.add(number);
            }
        }

        // сортировка чисел в порядке возрастания
        Collections.sort(listEvenNumbers);

        // вывод результата
        System.out.println(listEvenNumbers);
    }

}