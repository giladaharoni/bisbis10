package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.enitites.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

}
