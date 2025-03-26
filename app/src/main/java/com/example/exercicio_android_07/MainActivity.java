package com.example.exercicio_android_07;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Library library = new Library();

        String[] bookTitles = {
                "Java Programming",
                "Data Structures",
                "RUP - Rational Unified Process",
                "Data Science"
        };

        for (String title : bookTitles) {
            library.addBook(new Book(title, true));
        }

        library.addBook(new Book("Python Programming", false));

        Student student1 = new Student("Alice");
        library.addUser(student1);

        String[] booksToBorrow = {
                "Java Programming",
                "Data Structures",
                "Python Programming",
                "RUP - Rational Unified Process",
                "Data Science",
                "Non Existent Book"
        };

        for (String title : booksToBorrow) {
            try {
                library.borrowBook("Alice", title);
            } catch (Exception e) {
                Log.i("LibrarySystem", "Error: " + e.getMessage());
            }
        }

        for (String title : new ArrayList<>(student1.getBorrowedBooks())) {
            try {
                library.returnBook("Alice", title);
            } catch (Exception e) {
                Log.i("LibrarySystem", "Error: " + e.getMessage());
            }
        }
    }
}