package com.cooksys.lemonadestand.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name="order_table")
@Entity
@NoArgsConstructor
@Data
public class Order {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private double total;
	
	@OneToMany(mappedBy = "order")
	@ToString.Exclude
	private List<Lemonade> lemonades;
	
	@ManyToOne
	@JoinColumn
	@ToString.Exclude
	private Customer customer;
	
	@ManyToOne
	@JoinColumn
	@ToString.Exclude
	private LemonadeStand lemonadeStand;
	
//	@Override
//	public String toString() {
//	    return "Order{id=" + id + ", orderTotal=" + total + ", lemonades=" + lemonades +  ", customer=" + customer + ", lemonadeStand=" + lemonadeStand + "}";
//	}
}
