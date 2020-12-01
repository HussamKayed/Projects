import java.util.HashMap;

public class Shop {
    private final String name;
    private HashMap<Book, Integer> availableBooks;
    private int sales;

    /**
     * creates an object of the class Shop
     * @param name desired name for the shop
     * @param sales current sales of the shop
     */
    public Shop(String name, int sales)
    {
        this.name = name;
        this.availableBooks = new HashMap<Book, Integer>();
        this.sales = sales;
    }

    /**
     * Allows the customer to buy a book only if they have enough money or have enough on their tab
     * @param book The desired book for purchase
     * @param customer The customer that wants to buy the book
     */
    public void boughtBook(Book book, Customer customer)
    {
        if((customer.getMoney() + customer.getTab()) >= book.getPrice())
        {
            for (Book currentBook : availableBooks.keySet())
            {
                if (book.getTitle().equals(currentBook.getTitle()))
                {
                    if (availableBooks.get(currentBook) != 0)
                    {
                        int currentStock = availableBooks.get(currentBook) - 1;
                        availableBooks.put(currentBook, currentStock);
                    }
                    else
                    {
                        availableBooks.put(currentBook, 1);
                    }
                    sales += currentBook.getPrice();
                }
                else
                    System.out.println("Book not found");
            }
        }
        else
            System.out.println("Insufficient Funds");
    }

    /**
     * Displays the books found in store per the desired genre
     * @param genre the desired genre chosen by the customer
     */
    public void viewPerGenre(String genre)
    {
        for(Book currentBook: availableBooks.keySet())
        {
            if(currentBook.getGenre().equals(genre))
            {
                System.out.println(currentBook.getTitle());
            }
        }
    }

    /**
     * Displays all books that are available in store and how many of them is currently in stock
     */
    public void showAvailableBooks()
    {
        printAvailabilityHeader();

        for(Book currentBook: availableBooks.keySet())
        {
            System.out.println(currentBook.getTitle() + "    " + availableBooks.get(currentBook));
        }
    }

    private void printAvailabilityHeader()
    {
        System.out.println("Book    InStock");
    }

    /**
     * Compares between 2 shops which have the same book but my differ in price
     * @param competitor the shop which the current shop is being compared to
     * @param book the desired book to be compared in price between the two shops
     */
   public void compare(Shop competitor, Book book)
    {
        Book comparedBook = new Book("default", 0.0, 0, "default", "default");
        for(Book currentBook: competitor.availableBooks.keySet())
        {
            if(currentBook.getTitle().equals(book.getTitle()))
                comparedBook = currentBook;
            else
            {
                System.out.println("Book is not found in store");
                return;
            }
        }

        Book bookInMyStore = new Book("default", 0.0, 0, "default", "default");;
        for(Book currentBook: competitor.availableBooks.keySet())
        {
            if(currentBook.getTitle().equals(book.getTitle()))
                bookInMyStore = currentBook;
            else
            {
                System.out.println("Book is not found in store");
                return;
            }
        }

        if(comparedBook.getPrice() < bookInMyStore.getPrice())
            System.out.println("Buy" + book.getTitle() + " from the other store");
        else
            System.out.println("Buy" + book.getTitle() + " from my store");
    }

    /**
     * Adds a new book to the collection of books already found in the shop
     * @param book The book that is desired to be added
     * @return true if the book is successfully added, otherwise false
     */
    public boolean addNewBook(Book book)
    {
        boolean isValid = book.checkBookValidity();  //checking if the ISBN of the book is valid
        if(isValid)
        {
            if (availableBooks.containsKey(book))
            {
                int newStock = availableBooks.get(book) + 1;
                availableBooks.put(book, newStock);
            }
            else
            {
                availableBooks.put(book, 1);
            }
            System.out.println(book.getTitle() + " is added");
            return true;
        }
        else
            System.out.println("Invalid Book, Please check the book's ISBN");
        return false;
    }
}