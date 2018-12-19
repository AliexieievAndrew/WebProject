package dao;

import dto.Cart;
import dto.CartLine;

import java.util.List;

public interface CartLineDAO {
    CartLine get(int id);
    boolean add(CartLine cartLine);
    boolean update(CartLine cartLine);
    boolean delete(CartLine cartLine);

    List<CartLine> list(int cartId);

    // special methods
    List<CartLine> listOrdered(int cartId);
    CartLine getByCartAndProduct(int cartId, int productId);

    // Cart
    boolean updateCart(Cart cart);
}
