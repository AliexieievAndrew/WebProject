package service;

import dao.ProductDAO;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    public Product get(int productId) {
        return productDAO.get(productId);
    }

    public List<Product> list() {
        return productDAO.list();
    }

    public boolean add(Product product) {
        return productDAO.add(product);
    }

    public boolean update(Product product) {
        return productDAO.update(product);
    }

    public boolean delete(Product product) {
        return productDAO.delete(product);
    }

    public List<Product> listActiveProducts() {
        return productDAO.listActiveProducts();
    }

    public List<Product> listActiveProductsByCategory(int categoryId) {
        return productDAO.listActiveProductsByCategory(categoryId);
    }

    public List<Product> getLatestActiveProduct(int count) {
        return productDAO.getLatestActiveProduct(count);
    }
}
