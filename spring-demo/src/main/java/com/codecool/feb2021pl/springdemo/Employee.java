package com.codecool.feb2021pl.springdemo;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }
}
