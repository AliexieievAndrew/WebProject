package service;

import dto.Address;
import dto.Cart;
import dto.User;

public interface UserService {
    boolean addUser(User user);

    User getByEmail(String email);

    boolean addAddress(Address address);

    boolean updateCart(Cart cart);
}
