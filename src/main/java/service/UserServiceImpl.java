package service;

import dao.UserDAO;
import dto.Address;
import dto.Cart;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public User getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public boolean addAddress(Address address) {
        return userDAO.addAddress(address);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return userDAO.updateCart(cart);
    }
}
