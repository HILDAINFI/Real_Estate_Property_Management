package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.User;
import com.cts.dto.UserPropertyRequestDTO;
import com.cts.dto.UserPropertyResponseDTO;
import com.cts.feignclient.UserClient;
import com.cts.model.Property;
import com.cts.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyRepository repository;
	@Autowired
	UserClient userClient;
	@Override
	public String addProperty(UserPropertyRequestDTO property) {
		repository.save(property.getProperty());
		String response = userClient.saveUser(property.getUser());
		if (response.equals("User Saved"))
			return "Property Saved!!!";
		else
			return "Something went wrong!!!";
	}

	@Override
	public String deletePropertyById(int propertyId) {
		repository.deleteById(propertyId);
		return "Property deleted successfully";
	}

	@Override
	public UserPropertyResponseDTO getPropertyById(int propertyId)  {
		Property prop = repository.findById(propertyId).get();
		int userno = prop.getUserId();
		User user = userClient.getUserById(userno);
		UserPropertyResponseDTO responseDTO = new UserPropertyResponseDTO(user,prop);
		return responseDTO;
	}

	@Override
	public List<Property> getAllProperties() {
		
		return repository.findAll();
	}

	@Override
	public Property updateProperty(Property property) {
		
		return repository.save(property);
	}
	
	

}
