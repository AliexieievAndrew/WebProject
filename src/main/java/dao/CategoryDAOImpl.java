package dao;

import dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
    private static List<Category> categories = new ArrayList<Category>();

    // временное тест
    static {
        Category category = new Category();
        category.setId(1);
        category.setName("Television");
        category.setDescription("This is some description television");
        category.setImageURL("CAT_1.png");
        categories.add(category);

        category = new Category();
        category.setId(2);
        category.setName("Mobile");
        category.setDescription("This is some description mobile");
        category.setImageURL("CAT_2.png");
        categories.add(category);


        category = new Category();
        category.setId(3);
        category.setName("Laptop");
        category.setDescription("This is some description laptop");
        category.setImageURL("CAT_3.png");
        categories.add(category);


    }

    public List<Category> list() {
        return categories;
    }

    public Category get(int id) {
        for (Category category:categories) {
            if(category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
