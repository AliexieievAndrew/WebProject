package service;

import dao.CartLineDAO;
import dto.Cart;
import dto.CartLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartLineServiceImpl implements CartLineService {

    @Autowired
    CartLineDAO cartLineDAO;

    @Override
    public CartLine get(int id) {
        return cartLineDAO.get(id);
    }

    @Override
    public boolean add(CartLine cartLine) {
        return cartLineDAO.add(cartLine);
    }

    @Override
    public boolean update(CartLine cartLine) {
        return cartLineDAO.update(cartLine);
    }

    @Override
    public boolean delete(CartLine cartLine) {
        return cartLineDAO.delete(cartLine);
    }

    @Override
    public List<CartLine> list(int cartId) {
        return cartLineDAO.list(cartId);
    }

    @Override
    public List<CartLine> listAvailable(int cartId) {
        return cartLineDAO.listAvailable(cartId);
    }

    @Override
    public CartLine getByCartAndProduct(int cartId, int productId) {
        return cartLineDAO.getByCartAndProduct(cartId,productId);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return cartLineDAO.updateCart(cart);
    }
}
