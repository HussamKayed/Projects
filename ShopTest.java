import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    @Test
    public void testAddNewBook()
    {
        Book book1 = new Book("How to make friends", 20, 256, "Adventure", "9783608963762");
        Shop myStore = new Shop("El3azama", 0);

        assertTrue(myStore.addNewBook(book1));
    }
}