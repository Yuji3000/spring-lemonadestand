package com.cooksys.lemonadestand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.lemonadestand.entities.Lemonade;

@Repository
public interface LemonadeRepository extends JpaRepository<Lemonade, Long>{
	

}
