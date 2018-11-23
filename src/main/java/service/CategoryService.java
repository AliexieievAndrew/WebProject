package service;

import dto.Category;

import java.util.List;

public interface CategoryService {
    boolean addCategory(Category category);
    List<Category> list ();
    Category get(int id);
    boolean update(Category category);
    boolean delete(Category category);
}
