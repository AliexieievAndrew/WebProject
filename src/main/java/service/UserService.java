package service;

import dto.Address;
import dto.Cart;
import dto.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);
    User getByEmail(String email);

    boolean addAddress(Address address);
    List<Address> getDeliveryAddresses(User user);

    boolean updateCart(Cart cart);
}
