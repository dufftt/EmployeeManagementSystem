package com.cognizant.authenticationMS.service;

import com.cognizant.authenticationMS.model.AppUser;
import com.cognizant.authenticationMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerDetailsService implements UserDetailsService {

	// Class to Implement UserDetailsService in Spring security

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {

		AppUser user = null;
		user = userRepo.findById(userid).get();

		if (user != null) {
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());
			return new User(user.getUserid(), user.getPassword(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("Username/Password is Invalid...Please Check");
		}
	}

}
