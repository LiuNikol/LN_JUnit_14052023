package org.example.enums;

public enum CourseName {
    FRONT_END("Front-end Basic"),
    CSHARP("C# Basic");

    private String name;

    CourseName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}