package dao;

import dto.Address;
import dto.Cart;
import dto.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDAO")


public class UserDAOImpl implements UserDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {
        try {
            sessionFactory.getCurrentSession().persist(user);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public User getByEmail(String email) {

        // :email - it's param
        // hibernate not like char @
        String sql = "FROM User WHERE email = :email";
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createQuery(sql, User.class)
                    .setParameter("email",email)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }

    @Override
    public boolean addAddress(Address address) {
        try {
            sessionFactory.getCurrentSession().persist(address);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public List<Address> getDeliveryAddresses(User user) {
        String sql = "FROM Address WHERE user = :user";
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createQuery(sql)
                    .setParameter("user",user)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}