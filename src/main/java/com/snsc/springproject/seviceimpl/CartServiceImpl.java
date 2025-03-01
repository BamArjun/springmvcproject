package com.snsc.springproject.seviceimpl;
import com.snsc.springproject.model.Cart;
import com.snsc.springproject.repository.CartRepostory;
import com.snsc.springproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
@Autowired
    private  CartRepostory cartRepository;

//    @Autowired
//    public CartServiceImpl(CartRepostory cartRepository) {
//        this.cartRepository = cartRepository;
//    }

    @Override
    public void addTCart(Cart cart) {
        cartRepository.save(cart);
    }
}