package service;

import dao.CartLineDAO;
import dao.ProductDAO;
import dto.Cart;
import dto.CartLine;
import dto.Product;
import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    CartLineDAO cartLineDAO;

    @Autowired
    HttpSession httpSession;

    @Autowired
    ProductDAO productDAO;

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


    public String deleteCartLine(int cartLineId){
        CartLine cartLine = cartLineDAO.get(cartLineId);
        if (cartLine == null) {
            return "result=error";
        }

        Cart cart = this.getCart();
        cart.setTotal(cart.getTotal() - cartLine.getTotal());
        cart.setCartLines(cart.getCartLines() - 1);

        cartLineDAO.updateCart(cart);
        cartLineDAO.delete(cartLine);


        return "result=deleted";
    }

    public String addCartLine(int productId) {
        double oldTotal = 0;

        Product product = productDAO.get(productId);
        Cart cart = this.getCart();
        CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);

        if (cartLine == null) {
            cartLine = new CartLine();

            cartLine.setProduct(product);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setCartId(cart.getId());
            cartLine.setProductCount(1);
            cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());

            cartLineDAO.add(cartLine);
        } else {
            oldTotal = cartLine.getTotal();
            cartLine.setProductCount(cartLine.getProductCount() + 1);
            cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());

            cartLineDAO.update(cartLine);
        }

        cart.setTotal(cart.getTotal() - oldTotal + cartLine.getTotal());
        cart.setCartLines(cart.getCartLines() + 1);

        cartLineDAO.updateCart(cart);

        return "result=added";
    }

    public String checkout() {
        Cart cart = this.getCart();
        List<CartLine> cartLines = cartLineDAO.list(cart.getId());

        cartLines.forEach(e -> {
            e.setOrdered(true);
            cartLineDAO.update(e);
        });

        return "result=ordered";
    }

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            list.add("elemet: " + (j+1));
        }

        list.forEach(e->{
            System.out.println(e);
            e = e + "edit";
            System.out.println(e);});
    }

}