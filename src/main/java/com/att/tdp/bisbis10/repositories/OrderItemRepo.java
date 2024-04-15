package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.enitites.orders.OrderDish;
import com.att.tdp.bisbis10.enitites.orders.OrderDishPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderDish, OrderDishPK> {
}
