package com.example.restaurant_service.controoller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant_service.entity.Restaurant;
import com.example.restaurant_service.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {
	
	private final RestaurantRepository repo;  // <-- REMOVE = null
	
	@GetMapping
	public List<Restaurant> getAll()
	{
		return repo.findAll();
	}

	
	
	@PostMapping
	public String add(@RequestBody Restaurant r)
	{
		repo.save(r);
		
		return "Restaurant added";
	}
	
	
	 @GetMapping("/{id}")
	    public Restaurant getOne(@PathVariable Long id) {
	        return repo.findById(id)
	                .orElse(null);
	    }
}
