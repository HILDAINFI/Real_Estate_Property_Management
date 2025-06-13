package com.cts.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.cts.model.Property;
 
@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
	List<Property> findByStatusIgnoreCase(String status);
	List<Property> findByLocationAndPriceBetweenAndType(String location, double minPrice, double maxPrice, String type);
	int countByLocationAndPriceBetweenAndType(String location, double minPrice, double maxPrice, String type);
   

}