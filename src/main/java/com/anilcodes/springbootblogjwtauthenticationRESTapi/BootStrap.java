package com.anilcodes.springbootblogjwtauthenticationRESTapi;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.enums.UserRoleName;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.service.PasswordEncoderUtil;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.role.Role;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.role.RoleRepository;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.UserRepository;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {
	
	@Value("${admin.email}")
	private String adminEmailId;
	@Value("${admin.password}")
	private String adminPass;
	
	@Autowired
	private PasswordEncoderUtil passwordEncoderUtil;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (NumberUtils.INTEGER_ZERO.equals(roleRepository.findAny()))
			createRole();
		
		if (NumberUtils.INTEGER_ZERO.equals(userRepository.findAny()))
			saveAdminOnStartUp();
	}
	
	public void createRole() {
		try {

			Role role1 = new Role(UserRoleName.ROLE_ADMIN.getName(), "Admin");
			Role role2 = new Role(UserRoleName.ROLE_USER.getName(), "User");
			List<Role> rolesList = Arrays.asList(role1, role2);
			roleRepository.saveAll(rolesList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveAdminOnStartUp() {
		try {
			User superAdmin = new User();
			superAdmin.setFirstName("admin");
			superAdmin.setLastName("lastname");
			superAdmin.setEmail(adminEmailId);
			superAdmin.setPassword(passwordEncoderUtil.encode(adminPass));
			superAdmin.setIsActive(Boolean.TRUE);
			Role role = roleRepository.findByRole(UserRoleName.ROLE_ADMIN.getName());
			superAdmin.setRole(role);
			userRepository.save(superAdmin);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
