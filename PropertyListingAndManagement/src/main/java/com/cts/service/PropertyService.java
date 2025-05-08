package com.cts.service;


import java.util.List;

import com.cts.dto.UserPropertyRequestDTO;
import com.cts.dto.UserPropertyResponseDTO;
import com.cts.exception.PropertyNotFoundException;
import com.cts.model.Property;

public interface PropertyService {
	public abstract String addProperty(UserPropertyRequestDTO property);

	public abstract String deletePropertyById(int propertyId);

	public abstract UserPropertyResponseDTO getPropertyById(int propertyId);

	public abstract List<Property> getAllProperties();

	public abstract Property updateProperty(Property property);
}
