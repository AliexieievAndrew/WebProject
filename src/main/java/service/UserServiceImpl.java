package service;

import dao.UserDAO;
import dto.Address;
import dto.Cart;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional()
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
    public List<Address> getDeliveryAddresses(User user) {
        return userDAO.getDeliveryAddresses(user);
    }
}
