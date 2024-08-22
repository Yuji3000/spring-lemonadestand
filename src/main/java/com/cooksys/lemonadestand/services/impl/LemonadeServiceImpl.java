package com.cooksys.lemonadestand.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class LemonadeServiceImpl implements LemonadeService {

	private LemonadeRepository lemonadeRepository;

	@Override
	public List<Lemonade> getAllLemonades() {
		return lemonadeRepository.findAll();
	}

}
