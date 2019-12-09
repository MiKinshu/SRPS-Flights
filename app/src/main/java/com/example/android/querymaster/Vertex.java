package com.example.android.querymaster;

class Vertex {
    private String Name;
    private String Code;

    public Vertex(String name, String code) {
        Name = name;
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public String getCode() {
        return Code;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCode(String code) {
        Code = code;
    }
}