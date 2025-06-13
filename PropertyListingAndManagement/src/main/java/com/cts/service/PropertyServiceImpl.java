package com.cts.service;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.UserInfo;
import com.cts.exception.PropertyNotFoundException;
import com.cts.exception.UserNotFoundException;
import com.cts.feignclient.UserClient;
import com.cts.model.Property;
import com.cts.repository.PropertyRepository;
 
@Service
public class PropertyServiceImpl implements PropertyService {
 
    private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
    @Autowired
    PropertyRepository repository;
    @Autowired
    UserClient userClient;
 
 
    public String addProperty(Property property) {
        logger.info("Attempting to add property for sellerId: {}", property.getSellerId());
 
        UserInfo ui = userClient.getUserById(property.getSellerId());
        if (ui == null || ui.getId() != property.getSellerId()) {
            logger.error("Seller not found with ID: {}", property.getSellerId());
            throw new UserNotFoundException("Seller not found with ID: " + property.getSellerId());
        }
 
        repository.save(property);
        logger.info("Property saved successfully with ID: {}", property.getPropertyId());
        return "Property Saved!!!";
    }

 
    public String deletePropertyById(int propertyId) throws PropertyNotFoundException {
        logger.info("Attempting to delete property with ID: {}", propertyId);
 
        if (!repository.existsById(propertyId)) {
            logger.error("Property not found with ID: {}", propertyId);
            throw new PropertyNotFoundException("Property Not Found With ID: " + propertyId);
        }
 
        repository.deleteById(propertyId);
        logger.info("Property deleted successfully with ID: {}", propertyId);
        return "Property deleted successfully";
    }
 


    public Property getPropertyById(int propertyId) throws PropertyNotFoundException {
        logger.info("Fetching property with ID: {}", propertyId);
 
        Property prop = repository.findById(propertyId)
        		.orElseThrow(() -> {
                    logger.error("Property not found with ID: {}", propertyId);
                    return new PropertyNotFoundException("Property not found with ID: " + propertyId);
                });
 
        UserInfo user = userClient.getUserById(prop.getSellerId());
        if (user == null) {
            logger.error("User not found with ID: {}", prop.getSellerId());
            throw new UserNotFoundException("User not found with ID: " + prop.getSellerId());
        }
 
        logger.info("Property retrieved successfully: {}", prop);
        return prop;
    }
 

     public List<Property> getAllProperties() {
        logger.info("Fetching all properties");
        List<Property> properties = repository.findAll();
        logger.info("Total properties found: {}", properties.size());
        return properties;
    }
 

    public Property updateProperty(Property property) {
        logger.info("Updating property with ID: {}", property.getPropertyId());
        return repository.save(property);
    }
 
	
	public List<Property> getSoldProp() {
		return repository.findByStatusIgnoreCase("soldOut");
	}

 
	
	public List<Property> searchProperties(String location, double minPrice, double maxPrice, String type) {
		return repository.findByLocationAndPriceBetweenAndType(location, minPrice, maxPrice, type);
		}
 
	
	public int countProperties(String location, double minPrice, double maxPrice, String type) {
		return repository.countByLocationAndPriceBetweenAndType(location, minPrice, maxPrice, type);
		}



	
	
}