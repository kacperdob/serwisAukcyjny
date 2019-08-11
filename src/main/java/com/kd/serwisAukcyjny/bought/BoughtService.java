package com.kd.serwisAukcyjny.bought;

import com.kd.serwisAukcyjny.UserContextService;
import com.kd.serwisAukcyjny.auction.AuctionRepository;
import com.kd.serwisAukcyjny.cart.Cart;
import com.kd.serwisAukcyjny.cart.CartService;
import com.kd.serwisAukcyjny.user.Customer;
import com.kd.serwisAukcyjny.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoughtService {
    @Autowired
    private UserContextService userContextService;
    @Autowired
    private BoughtRepository boughtRepository;
    @Autowired
    private UsersRepository<Customer> usersRepository;
//    @Autowired
//    private CartService cartService;
//    @Autowired
//    private AuctionRepository auctionRepository;
//
//    public Bought placeBought(){
//        Cart cart = userContextService.getCart();
//        String loggedUserEmail = userContextService.getLoggedUserEmail();
//        Customer customer = usersRepository.findByUsername(loggedUserEmail).get();
//        cart.getBoughtLines()
//                .stream()
//                .peek(a->a.getAuction)
//    }
}
