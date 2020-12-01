import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    @Test
    public void testISBNValidity1()
    {
        Book book1 = new Book("How to make friends", 20, 256, "Adventure", "9783608963762");

        assertTrue(book1.checkBookValidity());
    }

    @Test
    public void testISBNValidity2()
    {
        Book book1 = new Book("How to win People", 30, 260, "Fantasy", "9783841335180");

        assertFalse(book1.checkBookValidity());
    }

    @Test
    public void testISBNValidity3()
    {
        Book book1 = new Book("Vertigo", 70, 290, "Fantasy", "9783442267747");

        assertTrue(book1.checkBookValidity());
    }

    @Test
    public void testISBNValidity4()
    {
        Book book1 = new Book("The Blue Elephant", 35, 400, "Fantasy", "978758245159");

        assertTrue(book1.checkBookValidity());
    }

    @Test
    public void testISBNValidity5()
    {
        Book book1 = new Book("Dogs", 90, 500, "Biography", "9783442267819");

        assertTrue(book1.checkBookValidity());
    }
}