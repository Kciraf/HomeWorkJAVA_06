import java.util.*;

/* Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов. */

public class Excercise {
    
    public static HashMap<String, LinkedList<Integer>> switchPhoneBook(HashMap<Integer, String> book) {
        HashMap<String, LinkedList<Integer>> result = new HashMap<String, LinkedList<Integer>>();
        
        Integer k;
        String v;
        for (var item : book.entrySet()) {
            k = item.getKey();
            v = item.getValue();
            LinkedList<Integer> temp = new LinkedList<>();
            if (!result.containsKey(v)) {
                result.put(v, temp);
                temp = result.get(v);
                temp.add(k);
                result.put(v, temp);
            }else{
                temp = result.get(v);
                temp.add(k);
                result.put(v, temp);
            }
        }
        return result;
    }

    public static void sortPrintPhoneBook(HashMap<String, LinkedList<Integer>> mapToPrint) {
        String[] keyList = new String[mapToPrint.keySet().size()];
        String temp, temp2;
        for (var item : mapToPrint.entrySet()) {
            temp = null;
            for (int i = 0; i < keyList.length; i++) {
                if (keyList[i] == null) {
                    keyList[i] = item.getKey();
                    i = keyList.length;                 
                } else if (item.getValue().size() > mapToPrint.get(keyList[i]).size()) {
                    temp = keyList[i];
                    keyList[i] = item.getKey();
                    if (i < keyList.length - 1) {
                        for (int j = i + 1; j < keyList.length; j++) {
                            temp2 = keyList[j];
                            keyList[j] = temp;
                            temp = temp2;
                        }
                    }
                    i = keyList.length;
                }
            }
        }
        System.out.println("Отсортированный по количеству телефонов справочник:");
        for (var item : keyList) {
            System.out.println(item + " " + mapToPrint.get(item));
        }
    }


    public static void main(String[] args) {
        HashMap<Integer, String> phoneBook = new HashMap<>();   //Входные данные, чтоб было что обрабатывать
        phoneBook.put(4864, "Vasiliy");
        phoneBook.put(84863, "Peter");
        phoneBook.put(5464, "Nikola");
        phoneBook.put(4845164, "Sasha");
        phoneBook.put(12, "Vasiliy");
        phoneBook.put(456, "Vasiliy");
        phoneBook.put(7867, "Sasha");
        phoneBook.put(12313, "Vasiliy");
        phoneBook.put(678, "Peter");
        phoneBook.put(999, "Peter");

        Scanner in = new Scanner(System.in);
        HashMap<String, LinkedList<Integer>> revPhoneBook = switchPhoneBook(phoneBook);



        System.out.println("Что надо делать?");
        String input = "", name = "";
        Integer numb;
        while (!input.equals("0")) {
            System.out.println("Что хотите сделать со списком? Варианты (выбирете цифру):");
            System.out.println("1- Вывести в исходном виде.");
            System.out.println("2- Вывести в виде имен с перечнем телефонов.");
            System.out.println("3- Вывести в виде имен с перечнем телефонов, в отсортированном по количеству телефонов виде.");
            System.out.println("4- Добавить/исправить в исходной книге телефон.");
            System.out.println("5- Удалить телефон.");
            System.out.println("0- Закончить работу с книгой.");
            input = in.nextLine();
            switch (input) {
                case "1":
                    System.out.println(phoneBook);
                    break;
                case "2":
                    revPhoneBook = switchPhoneBook(phoneBook);
                    System.out.println(revPhoneBook);
                    break;
                case "3":
                    revPhoneBook = switchPhoneBook(phoneBook);
                    sortPrintPhoneBook(revPhoneBook);
                    break;
                case "4":
                    System.out.println("Введите номер телефона: ");
                    numb = Integer.parseInt(in.nextLine());
                    System.out.println("Введите имя контакта: ");
                    name = in.nextLine();
                    phoneBook.put(numb, name);
                    break;
                case "5":
                    System.out.println("Каккой телефон удаляем? ");
                    numb = Integer.parseInt(in.nextLine());
                    phoneBook.remove(numb);
                    break;
                case "0":
                    System.out.println("Завершаем работу...");
                    break;
                default:
                    System.out.println("Не верная команда.");
                    break;
        }
        }
    }
}
