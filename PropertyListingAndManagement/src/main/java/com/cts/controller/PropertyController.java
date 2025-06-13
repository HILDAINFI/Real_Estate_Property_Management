package com.cts.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.PropertyNotFoundException;
import com.cts.model.Property;
import com.cts.service.PropertyService;

 
@RestController
@RequestMapping("/properties")
public class PropertyController {
 
	@Autowired
	PropertyService service;
 
	@PostMapping("/save" 	)
	public String saveProperty(@RequestBody Property property) {
		return service.addProperty(property);
	}
	@PutMapping("/update")
	public Property updateProperty(@RequestBody Property property) {
		return service.updateProperty(property);
	}
 
	@GetMapping("/fetchById/{propid}")
	public Property getProperty(@PathVariable("propid") int PropertyId) throws PropertyNotFoundException {
		return service.getPropertyById(PropertyId);
	}
 
	@GetMapping("/fetchAll")
	public List<Property> getAllProperties() {
		return service.getAllProperties();
	}
 
	@DeleteMapping("/deleteById/{propid}")
	public String deleteProperty(@PathVariable("propid") int propertyId) throws PropertyNotFoundException {
		return service.deletePropertyById(propertyId);
	}
	@GetMapping("/getSoldProperties")
	public List<Property> getSoldProperties() {
		return service.getSoldProp();
	}
 
	@GetMapping("/search")
	public List<Property> searchProperties(
		@RequestParam String location,
		@RequestParam double minPrice,
		@RequestParam double maxPrice,
		@RequestParam String type) {
	return service.searchProperties(location, minPrice, maxPrice, type);
	}




}