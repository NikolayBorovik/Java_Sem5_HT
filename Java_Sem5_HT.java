package Java_Seminar5.Java_Sem5_HT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Java_Sem5_HT {
    public static void main(String[] args) {
        // Задание
        // Реализуйте структуру телефонной книги с помощью HashMap.
        // Программа также должна учитывать, что во входной структуре будут
        // повторяющиеся имена с разными телефонами,
        // их необходимо считать, как одного человека с разными телефонами. Вывод должен
        // быть отсортирован по убыванию
        // числа телефонов.

        // Пример меню:
        // 1) Добавить контакт
        // 2) Вывести всех
        // 3) Выход

        // Иванов 123432
        // Иванов 546457
        // Иванов 788354

        // Map<String, ArrayList> ---- {Иванов:[23145, 456745, 56787], Петров:[4325,
        // 45674]}
        Scanner sc = new Scanner(System.in);

        String WelcomePrompt = "Please, enter: '1' to add a new contact, '2' to print out all the contacts and 'exit' t exit the program";
        String AddContactPrompt = "Please, enter name of the contact and then telephone number of the contact: ";

        Map<String, ArrayList<Integer>> TelBook = new HashMap<>();
        String str = GetStr(WelcomePrompt);
        while (!str.equals("exit")) {
            if (str.equals("1")) {
                AddContact(TelBook, GetStr(AddContactPrompt));
                str = GetStr(WelcomePrompt);
            }
            if (str.equals("2")) {
                PrintItAll(TelBook);
                str = GetStr(WelcomePrompt);
            }
            else {
            System.out.println("Wrong Entry!");
            str = GetStr(WelcomePrompt);
            }
        }

        System.out.println("Good Buy!");
        System.exit(1);
        sc.close();

    }

    public static void PrintItAll(Map<String, ArrayList<Integer>> TelBook) {
        Map<String, ArrayList<Integer>> temp = new HashMap<>();
        for (var item : TelBook.entrySet()) {
            temp.put(item.getKey(), item.getValue());
        }
        
        while(!temp.isEmpty()) {
            Map.Entry<String, ArrayList<Integer>> maxEntry = null;
            for (Map.Entry<String, ArrayList<Integer>> entry : temp.entrySet()) {
                if (maxEntry == null || entry.getValue().size() > maxEntry.getValue().size()) {
                    maxEntry = entry;
                }
            }
            System.out.println(maxEntry);
            temp.remove(maxEntry.getKey());
        }

    }

    public static String GetStr(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        String result = sc.nextLine();
        return result;
    }

    public static Map<String, ArrayList<Integer>> AddContact(Map<String, ArrayList<Integer>> TelBook, String contact) {
        String[] contactArr = contact.split(" ");
        ArrayList<Integer> phones = new ArrayList<>();
        if (TelBook.containsKey(contactArr[0])) {
            phones = TelBook.get(contactArr[0]);
        }
        phones.add(Integer.parseInt(contactArr[1]));
        TelBook.put(contactArr[0], phones);
        return TelBook;
    }

}
