import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void testValidityOfList() {
        Book book1 = new Book("How to make friends", 20, 256, "Adventure", "9783608963762");
        Book book2 = new Book("How to win People", 30, 260, "Fantasy", "9783841335180");
        Customer customer = new Customer("Hussam", 2, 200, 200);
        int bookCounter = 0;

        customer.getBooks().add(book1);
        customer.getBooks().add(book2);
        customer.getBooks().add(book2);  //not a typo

        for(Book currentBook: customer.getBooks())
        {
            bookCounter++;
        }


        assertEquals(bookCounter, 2);
    }



}