package com.cooksys.lemonadestand.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
import com.cooksys.lemonadestand.mappers.LemonadeMapper;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LemonadeServiceImpl implements LemonadeService {

	private LemonadeRepository lemonadeRepository;
	private LemonadeMapper lemonadeMapper;


	// Helper Methods
	private void setLemonadePrice(Lemonade lemonade) {
		lemonade.setPrice(lemonade.getLemonJuice() * .20 + lemonade.getWater() * .01
				+ lemonade.getSugar() * .15 + lemonade.getIceCubes() * .05 + .50);
	}
	
	private void validateLemonadeRequest(LemonadeRequestDto lemonadeRequestDto) {
		if (lemonadeRequestDto.getLemonJuice() == null || 
				lemonadeRequestDto.getWater() == null || 
				lemonadeRequestDto.getSugar() == null || 
				lemonadeRequestDto.getIceCubes() == null) {
			throw new BadRequestException("All Fields required for creating a lemonade request dto");
		}
	}
	
	private Lemonade getLemonade(Long id) {
		Optional<Lemonade> optionalLemonade = lemonadeRepository.findById(id);
		
		if (optionalLemonade.isEmpty()) {
			throw new NotFoundException("No Lemonade found with id:" + id);
		}
		
		return optionalLemonade.get();
	}
	//
	
	
	@Override
	public List<LemonadeResponseDto> getAllLemonades() {
		return lemonadeMapper.entitiesToResponseDtos(lemonadeRepository.findAll());
	}
	
	@Override
	public LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto) {
		validateLemonadeRequest(lemonadeRequestDto);
		Lemonade lemonadeToSave = lemonadeMapper.requestDtoToEntity(lemonadeRequestDto);
		setLemonadePrice(lemonadeToSave);

		return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToSave));
	}

	@Override
	public LemonadeResponseDto getLemonadeById(Long id) {
		
		return lemonadeMapper.entityToResponseDto(getLemonade(id));
	}

	@Override
	public LemonadeResponseDto updateLemonade(Long id, LemonadeRequestDto lemonadeRequestDto) {
		validateLemonadeRequest(lemonadeRequestDto);		
		Lemonade lemonadeToUpdate = getLemonade(id);
		lemonadeToUpdate.setIceCubes(lemonadeRequestDto.getIceCubes());
		lemonadeToUpdate.setLemonJuice(lemonadeRequestDto.getLemonJuice());
		lemonadeToUpdate.setSugar(lemonadeRequestDto.getSugar());
		lemonadeToUpdate.setWater(lemonadeRequestDto.getWater());
		setLemonadePrice(lemonadeToUpdate);
		
		return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToUpdate));
	}

	@Override
	public LemonadeResponseDto deleteLemonade(Long id) {
		Lemonade lemonadeToDelete = getLemonade(id);
		lemonadeRepository.delete(lemonadeToDelete);
		return lemonadeMapper.entityToResponseDto(lemonadeToDelete);
	}

	
}
