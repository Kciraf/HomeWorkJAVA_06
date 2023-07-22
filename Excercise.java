import java.util.*;

/* Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов. */

public class Excercise {
    public static void main(String[] args) {
        Map<Integer, String> phoneBook = new HashMap<>();   //Входные данные
        phoneBook.put(4864, "Вася");
        phoneBook.put(84863, "Петя");
        phoneBook.put(5464, "Коля");
        phoneBook.put(4845164, "Шура");
        phoneBook.put(12, "Вася");
        phoneBook.put(456, "Вася");
        phoneBook.put(7867, "Шура");
        phoneBook.put(12313, "Вася");
        phoneBook.put(678, "Петя");
        phoneBook.put(999, "Петя");

        
    }
}
