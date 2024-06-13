package org.exercice05.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specie;
    @Temporal(TemporalType.DATE)
    private LocalDate birthday;
    public Dog() {}
    public Dog(String name, String specie, LocalDate birthday) {
        this.name = name;
        this.specie = specie;
        this.birthday = birthday;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
