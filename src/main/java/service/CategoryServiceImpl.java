package service;

import dao.CategoryDAO;
import dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public boolean addCategory(Category category) {
        return categoryDAO.addCategory(category);
    }

    public List<Category> list() {
        return categoryDAO.list();
    }

    public Category get(int id) {
        return categoryDAO.get(id);
    }

    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    public boolean delete(Category category) {
        return categoryDAO.delete(category);
    }
}
