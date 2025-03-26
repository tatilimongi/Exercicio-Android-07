# 📚 Library Management System - Android App

**Library Management System** is an Android application for managing books, where users can borrow and return digital books. It allows for book availability checks, user status, and borrowing limits. The app is built using **Java**, **Android Studio**, and **Gradle**.

## 🚀 Features

- 📖 **Book management**: Books can be added, borrowed, and returned.
- 👤 **User management**: Students can register and borrow books.
- 📚 **Borrowing limits**: Users can borrow up to 3 books at once.
- 🔄 **Logging**: All actions (borrowing and returning books) are logged.
- ⚠️ **Exception handling**: Error messages when borrowing limits are exceeded or unavailable books are requested.

## 🛠️ Technologies Used

- **Java** (Main programming language)
- **Android Studio** (Development environment)
- **Gradle** (Build automation)
- **Logcat** (Logging system for debugging)

## 📂 Directory Structure

```
📦 Exercicio-Android-07
├── 📁 app
│ ├── 📁 manifests
│ ├── 📁 java
│ │ ├── 📁 com/example/exercicio_android_07
│ │ │ ├── Book.java
│ │ │ ├── Library.java
│ │ │ ├── LibraryItem.java
│ │ │ ├── MainActivity.java
│ │ │ ├── Student.java
│ │ │ ├── User.java
│ ├── 📁 com/example/exercicio_android_07 (androidTest)
│ ├── 📁 com/example/exercicio_android_07 (test)
│ ├── 📁 java (generated)
│ ├── 📁 res
│ ├── 📁 res (generated)
├── 📁 Gradle Scripts
├── README.md
``` 

## ⚙️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/tatilimongi/Exercicio-Android-07.git
   ```
2. Open **Android Studio** and import the project.
3. Build and run the application on an emulator or physical device.

## 📝 Example Usage
```java
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
```

## 🐱 Example Log Output

- Alice successfully borrowed Java Programming
- Alice successfully borrowed Data Structures
- Error: Book is already borrowed
- Alice successfully borrowed RUP - Rational Unified Process
- Error: User cannot borrow more books
- Error: Book not found
- Alice successfully returned Java Programming
- Alice successfully returned Data Structures
- Alice successfully returned RUP - Rational Unified Process
