package service;

import dao.CartLineDAO;
import dto.Cart;
import dto.CartLine;
import dto.Product;
import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    CartLineDAO cartLineDAO;

    @Autowired
    HttpSession httpSession;

    // when user logged userModel != null (look at GlobalController.class)
    private Cart getCart() {
        UserModel userModel = (UserModel) httpSession.getAttribute("userModel");
        return userModel.getCart();
    }

    public List<CartLine> getCartLines() {
        Cart cart = this.getCart();
        return cartLineDAO.list(cart.getId());
    }


    public String updateCartLine(int cartLineId, int count) {
        CartLine cartLine = cartLineDAO.get(cartLineId);

        if(cartLine == null) {
            return "result=error";
        } else {
            Product product = cartLine.getProduct();

            double oldTotal = cartLine.getTotal();
            cartLine.setProductCount(count);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setTotal(product.getUnitPrice() * count);
            cartLineDAO.update(cartLine);

            Cart cart = this.getCart();
            cart.setTotal(cart.getTotal() - oldTotal + cartLine.getTotal());

            cartLineDAO.updateCart(cart);

            return "result=updated";
        }
    }
}
