package handler;

import dto.Address;
import dto.Cart;
import dto.User;
import model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import service.UserService;

// this class is for spring web flow


@Component
public class RegisterHandler {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

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


    public String validateUser(User user, MessageContext messageContext) {
        String transitionResponse = "success";

        // checking the password
        if(!(user.getPassword().equals(user.getConfirmPassword()))){

            messageContext.addMessage(new MessageBuilder()
                    .error()
                    // confirmPassword is a path in User.class for form in signup-personal.ftl
                    .source("confirmPassword")
                    .defaultText("password doesn't match the confirm")
                    .build());
            transitionResponse = "failure";
        }

        // check for uniq email
        if (userService.getByEmail(user.getEmail())!=null) {
            messageContext.addMessage(new MessageBuilder()
                    .error()
                    // email is a path in User.class for form in signup-personal.ftl
                    .source("email")
                    .defaultText("email address is already used")
                    .build());
            transitionResponse = "failure";
        }
        return transitionResponse;
    }

    public void saveAll(RegisterModel registerModel){
        System.out.println("saveAll working");

        User user = registerModel.getUser();

        // testing
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setRole("USER");

        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        userService.addUser(user);

        Address address = registerModel.getAddress();
        address.setUser(user);

        userService.addAddress(address);
    }
}
