package com.cts.dto;

import com.cts.model.Property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPropertyRequestDTO {
	private User user;
	private Property property;
}
