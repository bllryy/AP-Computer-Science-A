import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
https://runestone.academy/ns/books/published/CHCAPCS25-26/topic-4-6-input-files.html
https://runestone.academy/ns/books/published/CHCAPCS25-26/topic-4-7-wrapper-classes.html
https://www.javaspring.net/blog/read-csv-java/
https://javabeat.net/write-data-csv-file-in-java/ (wolnt need to write)
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html
*/

public class myLibrary
{
    public static void main(String[] args)
    {
        ArrayList<myBook> books = new ArrayList<>();
        ArrayList<myPatron> patrons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 8)
        {
            System.out.println("1. Print all books");
            System.out.println("2. Print all patrons");
            System.out.println("3. Add a book");
            System.out.println("4. Add a patron");
            System.out.println("5. Check out a book");
            System.out.println("6. Return a book");
            System.out.println("7. Load books from CSV");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");
            try
            {
                choice = (int) Double.parseDouble(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a number.");
                continue;
            }

            if (choice == 1)
            {
                printBooks(books);
            }
            else if (choice == 2)
            {
                printPatrons(patrons);
            }
            else if (choice == 3)
            {
                addBook(books, scanner);
            }
            else if (choice == 4)
            {
                addPatron(patrons, scanner);
            }
            else if (choice == 5)
            {
                checkOutBook(books, patrons, scanner);
            }
            else if (choice == 6)
            {
                returnBook(books, patrons, scanner);
            }
            else if (choice == 7)
            {
                loadBooksFromCSV(books, scanner);
            }
            else if (choice == 8)
            {
                System.out.println("Goodbye!");
            }
        }

        scanner.close();
    }

    public static void printBooks(ArrayList<myBook> books)
    {
        if (books.size() == 0)
        {
            System.out.println("No books in the library.");
            return;
        }
        for (int i = 0; i < books.size(); i++)
        {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public static void printPatrons(ArrayList<myPatron> patrons)
    {
        for (int i = 0; i < patrons.size(); i++)
        {
            System.out.println((i + 1) + ". " + patrons.get(i));
        }
    }

    public static void addBook(ArrayList<myBook> books, Scanner scanner)
    {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        myBook newBook = new myBook(title, author, isbn);
        books.add(newBook);
        System.out.println("Added: " + newBook);
    }

    public static void addPatron(ArrayList<myPatron> patrons, Scanner scanner)
    {
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();

        myPatron newPatron = new myPatron(name, new ArrayList<>());
        patrons.add(newPatron);
        System.out.println("Added patron: " + name);
    }

    public static void checkOutBook(ArrayList<myBook> books, ArrayList<myPatron> patrons, Scanner scanner)
    {
        System.out.println("Available books:");
        for (int i = 0; i < books.size(); i++)
        {
            if (!books.get(i).getIsCheckedOut())
            {
                System.out.println((i + 1) + ". " + books.get(i).getTitle() + " by " + books.get(i).getAuthor());
            }
        }

        System.out.print("Enter book number: ");
        int bookIndex = (int) Double.parseDouble(scanner.nextLine()) - 1;

        System.out.println("Patrons:");
        for (int i = 0; i < patrons.size(); i++)
        {
            System.out.println((i + 1) + ". " + patrons.get(i).getName());
        }

        System.out.print("Enter patron number: ");
        int patronIndex = (int) Double.parseDouble(scanner.nextLine()) - 1;

        books.get(bookIndex).setIsCheckedOut(true);
        patrons.get(patronIndex).addBook(books.get(bookIndex));
        System.out.println(patrons.get(patronIndex).getName() + " checked out " + books.get(bookIndex).getTitle());
    }

    public static void returnBook(ArrayList<myBook> books, ArrayList<myPatron> patrons, Scanner scanner)
    {
        System.out.println("Patrons:");
        for (int i = 0; i < patrons.size(); i++)
        {
            System.out.println((i + 1) + ". " + patrons.get(i).getName());
        }

        System.out.print("Enter patron number: ");
        int patronIndex = (int) Double.parseDouble(scanner.nextLine()) - 1;

        myPatron patron = patrons.get(patronIndex);
        ArrayList<myBook> patronBooks = patron.getBooks();

        System.out.println(patron.getName() + "'s books:");
        for (int i = 0; i < patronBooks.size(); i++)
        {
            System.out.println((i + 1) + ". " + patronBooks.get(i).getTitle());
        }

        System.out.print("Enter book number to return: ");
        int bookIndex = (int) Double.parseDouble(scanner.nextLine()) - 1;

        patronBooks.get(bookIndex).setIsCheckedOut(false);
        System.out.println("Returned: " + patronBooks.get(bookIndex).getTitle());
        patronBooks.remove(bookIndex);
    }

    public static void loadBooksFromCSV(ArrayList<myBook> books, Scanner scanner)
    {
        System.out.println("Enter CSV file path or put the file in the current directory that this .java is in. (books.csv): ");
        String filePath = scanner.nextLine();

        try
        {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            if (fileScanner.hasNextLine())
            {
                // Skipping the header row
                fileScanner.nextLine();
            }

            int count = 0;
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                String isbn = parts[2];

                myBook newBook = new myBook(title, author, isbn);
                books.add(newBook);
                count++;
            }

            fileScanner.close();
            System.out.println("Loaded " + count + " books from " + filePath);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filePath);
        }
    }
}
