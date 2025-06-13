package com.cts.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.OrderRequest;
import com.cts.dto.OrderResponse;
import com.cts.feignclient.PaymentClient;
import com.cts.feignclient.UserClient;
import com.cts.model.Property;
import com.cts.repository.PropertyRepository;

@RestController
@RequestMapping("/properties")

public class PropertyPurchaseController {

	@Autowired
	private PaymentClient paymentClient;
	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private UserClient userClient;

	@PostMapping("/buy/{propertyId}")
	public String buyProperty(@PathVariable int propertyId, @RequestParam int amount, @RequestParam int userId) {
	    Optional<Property> propertyOpt = propertyRepository.findById(propertyId);
	    if (propertyOpt.isEmpty()) return "Property not found";
	    if(propertyOpt.get().getStatus().equals("sold")) return "Property Already Sold Out";
	    Property property = propertyOpt.get();
	    property.setStatus("sold");
	    propertyRepository.save(property);
	    OrderRequest orderRequest = new OrderRequest();
	    orderRequest.setAmount(BigInteger.valueOf(amount));
	    orderRequest.setUserId(userId);
	   // OrderResponse response = paymentClient.createOrder(orderRequest);
//	    Property property = propertyOpt.get();
//	    property.setStatus("sold");
//	    propertyRepository.save(property);
	    return "Payment successful. Property marked as sold.";
//	    if (response != null && response.getRazorpayOrderId() != null) {
//	        Property property = propertyOpt.get();
////	        property.setStatus("sold");
//	        propertyRepository.save(property);
//	        return "Payment successful. Property marked as sold.";
//	    } else {
//	        return "Payment failed.";
//	    }
	}
}
