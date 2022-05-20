package com.example.death_note.server;

public class PackageData {
    private String operationType;
    private String login;
    private String password;
    private String answer;

    public PackageData(String operationType, String login, String password) {
        this.operationType = operationType;
        this.login = login;
        this.password = password;
    }

    public PackageData(String answer) {
        this.answer = answer;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
