package org.example;

public enum Groups {
    WORK("Работа"),
    FRIENDS("Друзья"),
    FAMILY("Семья");


    private final String title;

    Groups(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
