package Bai3;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    protected int id;
    protected String name;
    protected String address;
    protected int priority = 0;
    protected String[] subjects;
    protected String type;

    public Student(int id) {
        this.id = id;
    }

    public Student(int id, String name, String address, int priority) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    // override lai hashcode va equal method de kiem tra 2 student co trung nhau hay khong
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID = " + id +
                "| Thi sinh: " + name + '\'' +
                "; Dia chi: " + address + '\'' +
                "; Muc uu tien: " + priority +
                "; Khoi thi: " + type;
    }
}
