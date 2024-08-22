package com.cooksys.lemonadestand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LemonadeRequestDto {

	private Double lemonJuice;
	
	private Double water;
	
	private Double sugar;
	
	private Integer iceCubes;
}
