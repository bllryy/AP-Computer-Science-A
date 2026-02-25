import java.util.ArrayList;

public class myPatron
{
    private String name;
    private ArrayList<myBook> books;

    public myPatron()
    {
        this.name = "";
        this.books = new ArrayList<>();
    }

    public myPatron(String name, ArrayList<myBook> books)
    {
        this.name = name;
        this.books = books;
    }

    public myPatron(myPatron otherPatron)
    {
        this.name = otherPatron.name;
        this.books = new ArrayList<>(otherPatron.books);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<myBook> getBooks()
    {
        return books;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBooks(ArrayList<myBook> books)
    {
        this.books = books;
    }

    public void addBook(myBook book)
    {
        books.add(book);
    }

    @Override
    public String toString()
    {
        String result = "Patron: " + name + " | Books: ";
            for (int i = 0; i < books.size(); i++)
            {
                result += books.get(i).getTitle();
                if (i < books.size() - 1)
                {
                    result += ", ";
                }
            }
        return result;
    }
}
