package org.exercice04.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cat {
    public static List<Cat> cats = new ArrayList<>();

    private String name;
    private String specie;
    private String favoriteFood;
    private LocalDate dateOfBirth;

    public Cat() {
    }
    public Cat(String name, String specie, String favoriteFood, LocalDate dateOfBirth) {
        this.name = name;
        this.specie = specie;
        this.favoriteFood = favoriteFood;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}