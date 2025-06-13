package com.cts.model;
//

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "properties")
//@Data
//public class Property {
//
//    @Id
//    @GeneratedValue
//    private int propertyId;
//
//    @NotBlank(message = "Title is mandatory")
//    private String title;
//
//    @NotBlank(message = "Location is mandatory")
//    private String location;
//
//    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
//    private double price;
//
//    @NotBlank(message = "Type is mandatory")
//    private String type;
//
//    @Positive(message = "Size must be a positive number")
//    private double size;
//
//    @Min(value = 0, message = "Bedrooms cannot be negative")
//    private int bedrooms;
//
//    @Min(value = 0, message = "Bathrooms cannot be negative")
//    private int bathrooms;
//
//    @NotBlank(message = "Status is mandatory")
//    private String status;
//
//    @NotNull(message = "Seller ID is required")
//    private Integer sellerId;
//}
//

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "properties")
@Data
public class Property {
	@Id
	@GeneratedValue
	private int propertyId;
	private String title;
	private String location;
	private double price;
	private String type;
	private double size;
	private int bedrooms;
	private int bathrooms;
	private String status;
	private int sellerId;
	private String image;


//	@Lob
//@Cx`olumn(name = "image", columnDefinition = "LONGBLOB")
//private byte[] image; // New field for storing image
//	
//
//@Transient
//private String base64Image; // Used only for receiving image in JSON


}