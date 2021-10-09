import domain.Product;
import domain.Smartphone;
import manager.ProductManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Smartphone firstPhone = new Smartphone(11, 40393, "A243", "Samsung");
    private Smartphone secondPhone = new Smartphone(22, 65000, "IPhone 12", "Apple");

    @BeforeEach
    void setUp() {
        repository.save(firstPhone);
        repository.save(secondPhone);
    }
    @Test
    void removeById() {
        Product[] expected = new Product[]{firstPhone};
        repository.removeById(22);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}