package com.example.exercicio_android_07;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String name;
    protected boolean isActive;
    protected static final int MAX_LOANS = 3;
    protected List<String> borrowedBooks = new ArrayList<>();

    public User(String name, boolean isActive) {
        this.name = name;
        this.isActive = true;
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < MAX_LOANS;
    }

    public void borrowBook(String title) {
        borrowedBooks.add(title);
    }

    public void returnBook(String title) {
        borrowedBooks.remove(title);
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        isActive = false;
    }

}
