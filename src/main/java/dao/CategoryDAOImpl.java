package dao;

import config.HibernateConfig;
import dto.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
@Transactional // need to create @Service and @ServiceImpl
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    public SessionFactory sessionFactory;

    // add category to DB table

    public boolean addCategory(Category category) {
        try {
            sessionFactory.getCurrentSession().persist(category);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
     * Getting all Categories where is_active = true/(1)
     * in the string sql need to use name of the class (not name of the table in DB)
     */
    public List<Category> list() {
        String sql = "FROM Category WHERE is_active = 1";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);

        return query.list();
    }

    /*
     * Getting single category by id
     */
    public Category get(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }

    /*
     * updating a single category
     */
    public boolean update(Category category) {
        try {
            sessionFactory.getCurrentSession().update(category);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Category category) {
        category.setActive(false);
        try{
            sessionFactory.getCurrentSession().update(category);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
