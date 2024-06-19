package org.exercice08_09.entity;

public class Car {
    private final int id;

    private String brand;
    private String model;
    private String color;
    private int year;

    private static int nbCars;
    public Car(String brand, String model, String color, int year) {
        this.id = ++nbCars;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
    }
    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
