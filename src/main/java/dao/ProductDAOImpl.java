package dao;

import dto.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    public SessionFactory sessionFactory;

    public Product get(int productId) {
        try{
            return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Product> list() {
        String sql = "FROM Product";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return query.list();
    }

    public boolean add(Product product) {
        try{
            sessionFactory.getCurrentSession().persist(product);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(Product product) {
        try{
            sessionFactory.getCurrentSession().update(product);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Product product) {
        try {
            product.setActive(false);
            sessionFactory.getCurrentSession().update(product);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Product> listActiveProducts() {
        String sql = "FROM Product WHERE is_active = 1";
        Query query =
                sessionFactory
                .getCurrentSession()
                .createQuery(sql);
        return query.list();
    }

    public List<Product> listActiveProductsByCategory(int categoryId) {
        String sql = "FROM Product WHERE is_active = 1 AND category_id = " + categoryId;
        Query query =
                sessionFactory
                .getCurrentSession()
                .createQuery(sql);
        return query.list();
    }

    public List<Product> getLatestActiveProduct(int count) {
        String sql = "FROM Product WHERE is_active = 1 ORDER BY id";
        Query query =
                sessionFactory
                .getCurrentSession()
                .createQuery(sql)
                .setFirstResult(0)
                .setMaxResults(count);
        return query.list();
    }
}
