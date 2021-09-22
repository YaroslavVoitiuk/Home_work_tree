package org.example;


import java.util.Objects;

public class Contact {
    private final String name;
    private final String secondName;
    private Groups groups;

    public Contact(String name, String secondName, Groups groups) {
        this.name = name;
        this.secondName = secondName;
        this.groups = groups;
    }

    public Contact(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return (Objects.equals(this.name, contact.name) || (this.name != null &&
                this.name.equals(contact.getName()))) &&
                (Objects.equals(this.secondName, contact.secondName) || (this.secondName != null &&
                        this.secondName.equals(contact.getSecondName())));

    }

    @Override
    public String toString() {
        return " Имя: " + name + ", Фамилия: " + secondName + ", Группа: " + groups.getTitle() + ";";
    }
}
