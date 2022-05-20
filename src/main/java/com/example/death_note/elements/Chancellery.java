package com.example.death_note.elements;

public class Chancellery {
    String name;
    String type;
    String count;

    public Chancellery(String name, String type, String count) {
        this.name = name;
        this.type = type;
        this.count = count;
    }

    public Chancellery() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

