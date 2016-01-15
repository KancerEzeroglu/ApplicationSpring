package com.bootstrap.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootstrap.web.db.dao.UserDao;
import com.bootstrap.web.db.model.Roles;
import com.bootstrap.web.db.model.User;

@Service("userLoginService")
public class UserLoginService implements UserDetailsService {

	@Autowired
	protected UserDao userDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		User dbUser = userDao.getByName(username);
		if(dbUser==null){
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("Username not found");
		}
		
		return new org.springframework.security.core.userdetails.User(dbUser.getUsername().trim(), dbUser.getPassword().trim(),true, true, true, true,getGrantedAuthorities(dbUser));
		
	}
		private List<GrantedAuthority> getGrantedAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	        for(Roles userRoles : user.getRoles()){
	            System.out.println("UserProfile : "+userRoles);
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + userRoles.getRolesName()));
	        }
	        System.out.print("authorities :"+authorities);
	        return authorities;
	    }
	

}
