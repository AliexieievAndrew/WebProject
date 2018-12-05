package dao;

import dto.Address;
import dto.Cart;
import dto.User;

public interface UserDAO {

    boolean addUser(User user);

    User getByEmail(String email);

    boolean addAddress(Address address);

    boolean updateCart(Cart cart);

    // not use, because using cascade = CascadeType.ALL in annotation @OneToOne
//    boolean addCart(Cart cart);
}
