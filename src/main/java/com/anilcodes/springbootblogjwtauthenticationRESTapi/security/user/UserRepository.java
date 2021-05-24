package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByUserId(UUID userId);
	
	@Query(value = "SELECT EXISTS (SELECT 1 FROM tbl_user)", nativeQuery = true)
	Integer findAny();
		
}
