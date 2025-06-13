package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cts.PropertyListingAndManagementApplication;
import com.cts.feignclient.UserClient;
import com.cts.model.Property;
import com.cts.repository.PropertyRepository;
import com.cts.service.PropertyServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = { PropertyListingAndManagementApplication.class })

class PropertyListingAndManagementApplicationTests {

	@InjectMocks
	private PropertyServiceImpl propertyService;

	@Mock
	private PropertyRepository repository;

	@Mock
	private UserClient userClient;

	@Test
	void addPropertyTest() {
	    // Sample Base64 image string (shortened for test)
	    String base64Image = Base64.getEncoder().encodeToString("fake-image-data".getBytes());

	    // Create property with base64 image
	    Property property = new Property();
	    property.setPropertyId(52);
	    property.setTitle("EDED");
	    property.setLocation("DD3W");
	    property.setPrice(23);
	    property.setType("DDCC");
	    property.setSize(846);
	    property.setBedrooms(2422);
	    property.setBathrooms(234);
	    property.setStatus("DDFV");
	    property.setSellerId(31);
	    

	    // Mock repository save
	    Mockito.when(repository.save(Mockito.any(Property.class))).thenAnswer(invocation -> invocation.getArgument(0));

	    // Call service
	    String response = propertyService.addProperty(property);

	    // Assert
	    assertEquals("Property Saved!!!", response);

	
	}

//	

//	@Test
//	void deletePropertyByIdTest() {
//		int propertyId = 1;
//		Mockito.when(repository.existsById(propertyId)).thenReturn(true);
//
//		String response = propertyService.deletePropertyById(propertyId);
//		assertEquals("Property deleted successfully", response);
//		Mockito.verify(repository, Mockito.times(1)).deleteById(propertyId);
//	}
//
//	@Test
//	void getAllPropertiesTest() {
//	    // Arrange: Create a list of properties
//	    List<Property> properties = Arrays.asList(
//	        new Property(52, "EDED", "DD3W", 23, "DDCC", 846, 2422, 234, "DDFV", 31, null, null)
//	    );
//
//	    // Mock the repository to return the list
//	    Mockito.when(repository.findAll()).thenReturn(properties);
//
//	    // Act: Call the service method
//	    List<Property> response = propertyService.getAllProperties();
//
//	    // Assert: Check if the response matches the mocked list
//	    assertEquals(properties, response);
//	    assertFalse(response.isEmpty());
//	    assertEquals(1, response.size());
//	    assertEquals("EDED", response.get(0).getTitle());
//	}
//
//
//	@Test
//	void updatePropertyTest() {
//	    // Arrange: Create a property object
//	    Property property = new Property(52, "EDED", "DD3W", 23, "DDCC", 846, 2422, 234, "DDFV", 31, null, null);
//
//	    // Mock the repository save method
//	    Mockito.when(repository.save(property)).thenReturn(property);
//
//	    // Act: Call the service method
//	    Property response = propertyService.updateProperty(property);
//
//	    // Assert: Verify the result
//	    assertEquals(property, response);
//	    assertEquals("EDED", response.getTitle());
//	    assertEquals(31, response.getSellerId());
//	}

}
