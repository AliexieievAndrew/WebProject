import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

// class will be using yhe AnnotationConfigApplicationContext and categoryDAO class
public class CategoryTestCase {
    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;

    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("OnlineShop");
        context.refresh();

        categoryDAO = (CategoryDAO) context.getBean(CategoryDAOImpl.class);
    }

    @Test
    public void testAddCategory(){
        category = new Category();

        category.setName("Television");
        category.setDescription("This is some description television");
        category.setImageURL("CAT_1.png");

        assertEquals("Successfully added a category inside the table", true,categoryDAO.addCategory(category));
    }
}
