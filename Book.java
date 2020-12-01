public class Book {
    private final String title;
    private final double price;
    private final int pages;
    private final String genre;
    private final String ISBN_13;

    public double getPrice() {
        return price;
    }

    /**
     * The book that is desired to be bought or read
     * @param title title of the book
     * @param price price of the book
     * @param pages number of pages of the book
     * @param genre what the book is really about
     * @param ISBN_13 Validity check number of the book
     */
    public Book(String title, double price, int pages, String genre, String ISBN_13)
    {
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.genre = genreSpecification(genre);
        this.ISBN_13 = ISBN_13;
    }

    public String getTitle()
    {
        return title;
    }

    public String getGenre()
    {
        return genre;
    }

    public int getPages()
    {
        return pages;
    }

    public String getISBN_13()
    {
        return ISBN_13;
    }

    /**
     * checks if the genre is one of those provided
     * @param genre desired genre entered by the customer
     * @return the desired genre, if the input is valid, otherwise throws an IllegalStateException
     */
    private String genreSpecification(String genre)
    {
        switch(genre)
        {
            case "Adventure" :
            case "Biography" :
            case "Comic" :
            case "Fantasy":
                return genre;
        }
        throw new IllegalStateException("please enter a valid genre");
    }

    /**
     * Checks if the ISBN number of the book is actually valid
     * @return true if it's valid, otherwise false
     */
    public boolean checkBookValidity()
    {
        int valueOfISBN = 0;

        for(int i = 0; i < this.getISBN_13().length() - 1; i++)
        {
            if(i != this.getISBN_13().length() - 2)
            {
                String currentChar = this.getISBN_13().substring(i, i + 1);   //currentChar is a number everytime
                if (i % 2 == 0)
                {
                    valueOfISBN += Integer.parseInt(currentChar);
                } else
                    valueOfISBN += Integer.parseInt(currentChar) * 3;
            }
            else if(i % 2 == 0)
            {
                String currentChar = this.getISBN_13().substring(i, i+1);
                valueOfISBN += Integer.parseInt(currentChar);
            }
            else
            {
                String currentChar = this.getISBN_13().substring(i, i+1);
                valueOfISBN += Integer.parseInt(currentChar) * 3;
            }
        }
        int remainder = valueOfISBN % 10;
        int decidingValue = 10;
        decidingValue -= remainder;  //decides whether it's valid

        return decidingValue < 10 ;
    }
}
