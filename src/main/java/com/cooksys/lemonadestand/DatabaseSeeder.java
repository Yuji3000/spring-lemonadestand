package com.cooksys.lemonadestand;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.repositories.CustomerRepository;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.repositories.LemonadeStandRepository;
import com.cooksys.lemonadestand.repositories.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

	private LemonadeRepository lemonadeRepository;
	private CustomerRepository customerRepository;
	private LemonadeStandRepository lemonadeStandRepository;
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// Create a Lemonade
		Lemonade lemonade = new Lemonade();
		lemonade.setLemonJuice(3.25);
		lemonade.setWater(2.50);
		lemonade.setSugar(1.25);
		lemonade.setIceCubes(5);
		lemonade.setPrice(4.50);
		lemonadeRepository.saveAndFlush(lemonade);

		// Create a Customer
		Customer customer = new Customer();
		customer.setName("bobby");
		customer.setPhoneNumber("1231231234");
		customerRepository.saveAndFlush(customer);

		// Create a LemonadeStand
		LemonadeStand lemonadeStand = new LemonadeStand();
		lemonadeStand.setName("Bobby's Lemonade Stand");
		lemonadeStandRepository.saveAndFlush(lemonadeStand);

		// Create an Order
		Order order = new Order();
		order.setTotal(5.0);
        order.setCustomer(customer);
        order.setLemonadeStand(lemonadeStand);
        order.setLemonades(List.of(lemonade));

		orderRepository.saveAndFlush(order);

		// Set Lemonade Order
//		lemonade.setOrder(order);		
		
		// Output all the data to confirm seeding
		System.out.println(lemonadeRepository.findAll());
		System.out.println(customerRepository.findAll());
		System.out.println(lemonadeStandRepository.findAll());
		System.out.println(orderRepository.findAll());
	}
}
