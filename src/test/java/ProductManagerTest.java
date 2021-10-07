import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1,200, "The Catcher In The Ray", "J. D. Salinger");
    private Book secondBook = new Book(2, 500, "Fight Club", "Chuck Palahniuk");
    private Book thirdBook = new Book(3, 546, "NotApple", "Chuck Palahniuk");
    private Smartphone firstPhone = new Smartphone(11, 40393, "A243", "Samsung");
    private Smartphone secondPhone = new Smartphone(22, 65000, "IPhone 12", "Apple");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
    }

    @Test
    void shouldSearchBookName() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("The Catcher In The Ray");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthor() {
        Product[] expected = new Product[]{secondBook, thirdBook};
        Product[] actual = manager.searchBy("Chuck Palahniuk");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProducer() {
        Product[] expected = new Product[]{firstPhone};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneName() {
        Product[] expected = new Product[]{secondPhone};
        Product[] actual = manager.searchBy("IPhone 12");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearch() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("WHAT");

        assertArrayEquals(expected, actual);
    }
}