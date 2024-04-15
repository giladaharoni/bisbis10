package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.enitites.orders.OrderRest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderRest, String> {
}
