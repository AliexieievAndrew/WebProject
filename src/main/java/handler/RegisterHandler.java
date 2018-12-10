package handler;

import dto.Address;
import dto.Cart;
import dto.User;
import model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;

// this class is for spring web flow


@Component
public class RegisterHandler {

    @Autowired
    UserService userService;

    public RegisterModel init() {
        return new RegisterModel();
    }

    // for state store the flow instance inside the register model
    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }


    // for state store the flow instance inside the register model
    public void addAddress(RegisterModel registerModel, Address billing){
        registerModel.setAddress(billing);
    }

    public void saveAll(RegisterModel registerModel){
        System.out.println("saveAll working");

        User user = registerModel.getUser();
        user.setRole(2);

        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        userService.addUser(user);

        Address address = registerModel.getAddress();
        address.setUser(user);

        userService.addAddress(address);
    }
}
