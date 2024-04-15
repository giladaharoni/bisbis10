package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.enitites.orders.*;
import com.att.tdp.bisbis10.repositories.OrderItemRepo;
import com.att.tdp.bisbis10.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderItemRepo itemRepo;

    @PostMapping("")
    ResponseEntity<String> addOrder(@RequestBody OrderRequest request){
        OrderRest order = orderRepo.save(new OrderRest(request.getRestaurantId()));
        for (OrderItemRequest itemRequest: request.getOrderItems()){
            itemRepo.save(new OrderDish(new OrderDishPK(order.getOrderId(), itemRequest.getDishId(),
                    itemRequest.getAmount())));
        }
        return ResponseEntity.ok("OK");
    }



}
