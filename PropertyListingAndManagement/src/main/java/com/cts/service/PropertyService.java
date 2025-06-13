package com.cts.service;
 
import java.util.List;
 
import com.cts.exception.PropertyNotFoundException;
import com.cts.model.Property;
 
public interface PropertyService {
	public abstract String addProperty(Property property);
 
	public abstract String deletePropertyById(int propertyId) throws PropertyNotFoundException;
 
	public abstract Property getPropertyById(int propertyId) throws PropertyNotFoundException;
 
	public abstract List<Property> getAllProperties();
 
	public abstract Property updateProperty(Property property);
 
	public abstract List<Property> getSoldProp();
 
	public abstract List<Property> searchProperties(String location, double minPrice, double maxPrice, String type);
 
	public abstract int countProperties(String location, double minPrice, double maxPrice, String type);

 
}