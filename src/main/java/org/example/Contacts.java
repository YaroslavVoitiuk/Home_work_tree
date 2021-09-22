package org.example;

import java.util.HashMap;
import java.util.Map;

public class Contacts {
    private final int NAME = 0;
    private final int SECOND_NAME = 1;

    Map<String, Contact> contacts = new HashMap<>();
    Groups groups;

    public void addContact() {
        System.out.println("Введите имя, фамилию, номер и групу через пробел:");
        String[] data = Main.scanner.nextLine().split(" ");
        int NUMBER = 2;
        if (!contacts.containsKey(data[NUMBER])) {
            Contact contact = new Contact(data[NAME], data[SECOND_NAME], getGroup(data));
            contacts.put(data[NUMBER], contact);
        } else {
            System.out.println("Такой номер уже существует");
        }
    }

    public Groups getGroup(String[] data) {
        for (Groups g : Groups.values()) {
            int GROUP = data.length-1;
            if (g.getTitle().equalsIgnoreCase(data[GROUP])) {
                groups = g;
            }
        }
        return groups;
    }

    public void deleteContact() {
        if (!contacts.isEmpty()) {
            System.out.println("Введите имя и фамилию:");
            String[] input = Main.scanner.nextLine().split(" ");
            Contact contact = new Contact(input[NAME], input[SECOND_NAME]);
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                if (entry.getValue().equals(contact)) {
                    contacts.remove(entry.getKey());
                    System.out.println("Контакт успешно удалён! ");
                }
            }
        } else {
            System.out.println("Список контактов пуст!");
        }
    }

    public void findContact() {
        if (!contacts.isEmpty()) {
            System.out.println("Введите номер:");
            String input = Main.scanner.nextLine();
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                if (entry.getKey().equals(input)) {
                    System.out.println(entry.getValue());
                }
            }
        } else {
            System.out.println("Список контактов пуст!");
        }
    }

    public void printContacts() {
        if (!contacts.isEmpty()) {
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                System.out.println("Номер: " + entry.getKey() + ";" + entry.getValue());
            }
        } else {
            System.out.println("Список контактов пуст!");
        }
    }

    public void modifyContact(){
        if (!contacts.isEmpty()) {
            System.out.println("Введите номер:");
            String input = Main.scanner.nextLine();
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                if (entry.getKey().equals(input)) {
                    System.out.println("Введите новые данные для этого номера: " + entry.getKey());
                    String [] data = Main.scanner.nextLine().split(" ");
                    Contact contact = new Contact(data[NAME],data[SECOND_NAME],getGroup(data));
                    contacts.put(entry.getKey(),contact);
                }
            }
        } else {
            System.out.println("Список контактов пуст!");
        }
    }


}
