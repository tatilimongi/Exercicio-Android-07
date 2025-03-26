package com.example.exercicio_android_07;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, User> users;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public void borrowBook(String username, String bookTitle) {
        User user = users.get(username);
        Book book = books.get(bookTitle);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        if (!user.canBorrow()) {
            throw new IllegalStateException("User cannot borrow more books");
        }

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already borrowed");
        }

        books.put(bookTitle, new Book(bookTitle, false));
        user.borrowBook(bookTitle);
        Log.i("LibrarySystem", user.getName() + " successfully borrowed " + book.getTitle());
    }

    public void returnBook(String username, String bookTitle) {
        User user = users.get(username);
        Book book = books.get(bookTitle);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        user.returnBook(bookTitle);
        books.put(bookTitle, new Book(bookTitle, true));
        Log.i("LibrarySystem", user.getName() + " successfully returned " + book.getTitle());
    }
}
