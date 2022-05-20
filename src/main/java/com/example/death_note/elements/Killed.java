package com.example.death_note.elements;

public class Killed {
    Long ID;
    String name;
    String surname;
    String gender;
    String nationality;
    int age;

    public Killed(Long ID, String name, String surname, String gender, String nationality, int age) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
    }

    public Killed(String name, String surname, String gender, String nationality, int age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
    }

    public Killed() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return ID + " " + name + " " + surname + " " + gender + " " + nationality + " " + age;
    }
}
