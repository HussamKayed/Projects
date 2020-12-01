import java.util.HashSet;

public class Customer {
    private String name;
    private int ownedBooks;
    private HashSet<Book> books;
    private double money;
    private double tab;

    /**
     * Creates an object of the customer in order to save his data to be used when desired
     * @param name name of the customer
     * @param ownedBooks number of owned books that are bought from the current shop by the customer
     * @param money money owned by the customer
     * @param tab money that the customer has available on his tab in the store
     */
    public Customer(String name, int ownedBooks, double money, double tab) {
        this.name = name;
        this.ownedBooks = ownedBooks;
        this.books = new HashSet<Book>();
        this.money = money;
        this.tab = tab;
    }

    public String getName()
    {
        return name;
    }

    public int getOwnedBooks()
    {
        return ownedBooks;
    }

    public HashSet<Book> getBooks()
    {
        return books;
    }

    public double getMoney()
    {
        return money;
    }

    public double getTab()
    {
        return tab;
    }

    public void setBooks(HashSet<Book> books)
    {
        this.books = books;
    }
}
