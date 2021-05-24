package com.anilcodes.springbootblogjwtauthenticationRESTapi.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

	public boolean existsByName(String name);
	
	public Tag findByName(String name);
	
}
