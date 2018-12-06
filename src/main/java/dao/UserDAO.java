package dao;

import dto.Address;
import dto.Cart;
import dto.User;

import java.util.List;

public interface UserDAO {

    // User
    boolean addUser(User user);
    User getByEmail(String email);

    // Address
    boolean addAddress(Address address);
    List<Address> getDeliveryAddresses(User user);

    // Cart
    boolean updateCart(Cart cart);

    // doesn't using, because using cascade = CascadeType.ALL in annotation @OneToOne
//    boolean addCart(Cart cart);
}
