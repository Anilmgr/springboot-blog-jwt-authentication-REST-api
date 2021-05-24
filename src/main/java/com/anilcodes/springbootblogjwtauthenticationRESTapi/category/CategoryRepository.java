package com.anilcodes.springbootblogjwtauthenticationRESTapi.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public boolean existsByName(String name);
	
	public Category findByName(String name);

	
}
