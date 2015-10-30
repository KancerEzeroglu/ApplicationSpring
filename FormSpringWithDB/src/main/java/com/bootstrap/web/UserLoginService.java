package com.bootstrap.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootstrap.web.db.dao.UserDao;
import com.bootstrap.web.db.model.User;

@Service("userLoginService")
public class UserLoginService implements UserDetailsService {

	@Autowired
	protected UserDao userDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		User dbUser = userDao.getByName(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(dbUser.getUsername(),dbUser.getPassword(), true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_USER") });
        return user;
		
	}

}
