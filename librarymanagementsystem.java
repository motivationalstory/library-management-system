import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem extends JFrame {

    private List<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();

        // Set up the main frame
        setTitle("Library Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JButton addButton = new JButton("Add Book");
        JTextArea bookListArea = new JTextArea(10, 30);
        bookListArea.setEditable(false);

        // Add action listener for the "Add Book" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();

                if (!title.isEmpty() && !author.isEmpty()) {
                    addBook(title, author);
                    updateBookList(bookListArea);
                }
            }
        });

        // Set up layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(new JLabel("Title: "));
        add(titleField);
        add(new JLabel("Author: "));
        add(authorField);
        add(addButton);
        add(new JScrollPane(bookListArea));

        // Set up initial book list
        updateBookList(bookListArea);
    }

    private void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    private void updateBookList(JTextArea bookListArea) {
        bookListArea.setText("");
        for (Book book : books) {
            bookListArea.append(book.getTitle() + " by " + book.getAuthor() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryManagementSystem().setVisible(true);
            }
        });
    }

    private static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }
}
