package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    private final Map<LocalDateTime, String> missedCalls = new TreeMap<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void addMissedCall(String number) {
        missedCalls.put(LocalDateTime.now(), number);
    }

    public void showCalls() {
        if (!Main.contact.getContacts().isEmpty()) {
            for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
                for (Map.Entry<String, Contact> ent : Main.contact.getContacts().entrySet()) {
                    String date = formatter.format(entry.getKey());
                    if (entry.getValue().equals(ent.getKey())) {
                        System.out.println("Пропущенный звонок " + date + " от" + ent.getValue());
                    } else {
                        System.out.println("Пропущенный звонок " + date + " от " + entry.getValue());
                    }
                }
            }
        } else if (missedCalls.isEmpty()) {
            System.out.println("Журнал пропущенных звонков пуст!");
        } else {
            for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
                String date = formatter.format(entry.getKey());
                System.out.println("Пропущенный звонок " + date + " от " + entry.getValue());
            }
        }
    }

    public void clearCalls() {
        if (!missedCalls.isEmpty()) {
            missedCalls.clear();
            System.out.println("Журнал пропущенных звонков очищен!");
        } else {
            System.out.println("Журнал пропущенных звонков пуст!");
        }
    }

}
