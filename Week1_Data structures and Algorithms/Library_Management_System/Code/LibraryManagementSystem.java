package Library_Management_System.Code;

import java.util.*;

public class LibraryManagementSystem {
    static class Book implements Comparable<Book> {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("Book{id=%d, title='%s', author='%s'}", bookId, title, author);
        }

        @Override
        public int compareTo(Book o) {
            return this.title.compareToIgnoreCase(o.title);
        }
    }

    // Linear search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    // Binary search by title (array must be sorted by title)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Pride and Prejudice", "Jane Austen"),
            new Book(5, "Moby Dick", "Herman Melville")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose search method: 1. Linear Search 2. Binary Search");
        int method = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Title to search: ");
        String searchTitle = scanner.nextLine();

        Book found = null;
        if (method == 1) {
            found = linearSearch(books, searchTitle);
        } else if (method == 2) {
            Arrays.sort(books); // Ensure sorted for binary search
            found = binarySearch(books, searchTitle);
        } else {
            System.out.println("Invalid method.");
            return;
        }

        if (found != null) {
            System.out.println("Book found: " + found);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nAnalysis:");
        System.out.println("Linear Search: O(n) time complexity. Works on unsorted data, best for small or unsorted lists.");
        System.out.println("Binary Search: O(log n) time complexity. Requires sorted data, best for large sorted lists.");
    }
}
