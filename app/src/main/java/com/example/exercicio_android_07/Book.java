package com.example.exercicio_android_07;

public class Book  implements LibraryItem{
    private String title;
    private boolean available;

    public Book(String title, boolean available) {
        this.title = title;
        this.available = available;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrowItem() {
        if (available) {
            available = false;
        } else {
            throw new IllegalStateException("Book is not available");
        }
    }

    @Override
    public void returnItem() {
        available = true;
    }
}
