package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.role;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>{
	Role findByRole(String roleUser);
	
	@Query(value = "SELECT EXISTS (SELECT 1 FROM tbl_role)", nativeQuery = true)
	Integer findAny();
}
