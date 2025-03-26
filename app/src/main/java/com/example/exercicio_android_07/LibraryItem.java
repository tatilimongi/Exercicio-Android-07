package com.example.exercicio_android_07;

public interface LibraryItem {
    String getTitle();
    boolean isAvailable();
    void borrowItem();
    void returnItem();
}
