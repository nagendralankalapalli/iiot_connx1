
package com.beauto.iiotconnx.servicesimpl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.model.User;
import com.beauto.iiotconnx.repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	

	@Autowired
    private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.getUserByEmail(email);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				Collections.singleton(getUserRole(user.getRoleId())));
	}

	private GrantedAuthority getUserRole(int roleId) {
		switch (roleId) {
		case 1:
			return new SimpleGrantedAuthority("ROLE_ADMIN");
		case 2:
			return new SimpleGrantedAuthority("ROLE_USER");
//		case 3:
//			return new SimpleGrantedAuthority("ROLE_MANAGER");
			
		default:
			return new SimpleGrantedAuthority("ROLE_USER");
		}
	}

}
