package com.book.Dao;

import java.util.List;

import com.book.pojo.Cart;


public interface CartDao {
	boolean addToCart(Cart ca);
	boolean updateCart(Cart ca);
	boolean removeFromCartByCartId(int cartId);
	boolean clearCart(String custEmail);
	List<Cart> showCart();
	Cart searchFromCartByCartId(int cartId);
	List<Cart> searchFromCartBycustEmail(String custEmail);
	
}
