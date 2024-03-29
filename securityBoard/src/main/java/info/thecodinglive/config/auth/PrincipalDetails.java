package info.thecodinglive.config.auth;

import java.util.ArrayList;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import info.thecodinglive.model.Users;

public class PrincipalDetails implements UserDetails{
	private Users user;
	public PrincipalDetails(Users user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect=new ArrayList<>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				
				return user.getRoleType();   
			}
		});
		return collect;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();   
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();  
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
