package org.example.ClassesForLists;

public class Worker {
    private String type;
    private String name;
    private String birthday;
    private double salary;

    public Worker(String type, String name, String birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }

}
