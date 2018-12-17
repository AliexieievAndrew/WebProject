package dao;

import dto.Cart;
import dto.CartLine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartLineDAOImpl implements CartLineDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public CartLine get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean add(CartLine cartLine) {
        try {
            System.out.println("Проверка вставки");
            sessionFactory.getCurrentSession().persist(cartLine);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().update(cartLine);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().delete(cartLine);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CartLine> list(int cartId) {
        String sql = "FROM CartLine WHERE cartId = :cartId";

        return sessionFactory
                .getCurrentSession()
                .createQuery(sql,CartLine.class)
                .setParameter("cartId", cartId)
                .getResultList();
    }

    @Override
    public List<CartLine> listAvailable(int cartId) {
        String sql = "FROM CartLine WHERE cartId = :cartId AND is_available = 1";

        return sessionFactory
                .getCurrentSession()
                .createQuery(sql,CartLine.class)
                .setParameter("cartId", cartId)
                .getResultList();
    }

    @Override
    public CartLine getByCartAndProduct(int cartId, int productId) {
        String sql = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createQuery(sql,CartLine.class)
                    .setParameter("cartId", cartId)
                    .setParameter("productId",productId)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().update(cart);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
