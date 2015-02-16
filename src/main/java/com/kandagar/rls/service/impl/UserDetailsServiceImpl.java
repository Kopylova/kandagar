package com.kandagar.rls.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kandagar.rls.dao.UserDao;
import com.kandagar.rls.domain.Role;
import com.kandagar.rls.domain.User;
          
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findUserByName(username); 
		
		if(user!=null){
			String password = user.getPassword();
			boolean enabled = user.getIsActive();
			boolean accountNonExpired = user.getIsActive();
			boolean credentialsNonExpired = user.getIsActive();
			boolean accountNonLocked = user.getIsActive();
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			Role role = user.getRole();
			authorities.add(new GrantedAuthorityImpl(role.getName()));
			org.springframework.security.core.userdetails.User securityUser = new 
					org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("Пользователь не найден");
		}
	}

}
