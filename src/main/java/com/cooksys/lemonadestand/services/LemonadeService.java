package com.cooksys.lemonadestand.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;

@Service
public interface LemonadeService {

	List<LemonadeResponseDto> getAllLemonades();

	ResponseEntity<LemonadeResponseDto> createLemonade(LemonadeRequestDto lemonadeRequestDto);

	ResponseEntity<LemonadeResponseDto> getLemonadeById(Long id);
	
	

}
