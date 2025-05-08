package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private int userId;

//    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Image> images;

	// Getters and Setters
}
