package com.example.death_note.elements;

public class Shinigami implements User {
    private String login;
    private String password;
    private double leftToLive;

    public Shinigami(String login, String password, double leftToLive) {
        this.login = login;
        this.password = password;
        this.leftToLive = leftToLive;
    }

    public Shinigami() {
    }

    public Shinigami(String login, String password) {
        this.login = login;
        this.password = password;
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

    public double getLeftToLive() {
        return leftToLive;
    }

    public void setLeftToLive(double leftToLive) {
        this.leftToLive = leftToLive;
    }
}
