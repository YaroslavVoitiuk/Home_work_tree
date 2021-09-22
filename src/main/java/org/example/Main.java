package org.example;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Contacts contact = new Contacts();

    public static void main(String[] args) {
        boolean isWorking = true;
        MissedCalls missedCalls = new MissedCalls();

        while (isWorking) {
            System.out.println("1. Добавить контакт\n" +
                    "2. Добавить пропущенный вызов\n" +
                    "3. Вывести все пропущенные вызовы\n" +
                    "4. Очистить пропущенные вызовы\n" +
                    "5. Удалить контакт\n" +
                    "6. Найти контакт по номеру\n" +
                    "7. Вывести все контакты\n" +
                    "8. Изменить контакт\n"  +
                    "9. Выйти");
            printBorder();
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    contact.addContact();
                    printBorder();
                    break;
                case 2:
                    missedCalls.addMissedCall();
                    printBorder();
                    break;
                case 3:
                    missedCalls.showCalls();
                    printBorder();
                    break;
                case 4:
                    missedCalls.clearCalls();
                    printBorder();
                    break;
                case 5:
                    contact.deleteContact();
                    printBorder();
                    break;
                case 6:
                    contact.findContact();
                    printBorder();
                    break;
                case 7:
                    contact.printContacts();
                    printBorder();
                    break;
                case 8:
                    contact.modifyContact();
                    printBorder();
                    break;
                case 9:
                    printBorder();
                    System.out.println("Программа завершена!");
                    printBorder();
                    isWorking = false;
                    break;
                default:
                    System.out.println("Вы ввели не верное число!");
                    printBorder();
            }
        }
    }

    public static void printBorder() {
        System.out.println("----------------------");
    }
}
