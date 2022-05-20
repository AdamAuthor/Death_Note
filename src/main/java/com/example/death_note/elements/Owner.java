package com.example.death_note.elements;

import java.util.ArrayList;

public class Owner implements User {
    private String login;
    private String password;
    private int leftToLive;
    private ArrayList<Chancellery> items;

    public Owner(String login, String password, int leftToLive, ArrayList<Chancellery> items) {
        this.login = login;
        this.password = password;
        this.leftToLive = leftToLive;
        this.items = items;
    }

    public Owner(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Owner() {
    }

    public Owner(String login, String password, int leftToLive) {
        this.login = login;
        this.password = password;
        this.leftToLive = leftToLive;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getLeftToLive() {
        return leftToLive;
    }

    public void setLeftToLive(int leftToLive) {
        this.leftToLive = leftToLive;
    }

    public ArrayList<Chancellery> getItems() {
        return items;
    }

    public void setItems(ArrayList<Chancellery> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return login + " " + password + " " + leftToLive;
    }
}
