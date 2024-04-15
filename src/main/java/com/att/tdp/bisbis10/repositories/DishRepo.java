package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.enitites.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepo extends JpaRepository<Dish,Integer> {
}
