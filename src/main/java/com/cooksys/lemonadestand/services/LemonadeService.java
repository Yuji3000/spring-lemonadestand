package com.cooksys.lemonadestand.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;

@Service
public interface LemonadeService {

	List<Lemonade> getAllLemonades();
	
	

}
