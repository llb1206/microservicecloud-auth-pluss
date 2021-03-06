package com.llb.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public class User implements UserDetails, Serializable {
	private Long id;

	private String username;

	private String password;

	private List<Role> authorities;


	public User() {
	}

	public User(String username, String password, List<Role> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "Userxx*-*-**-{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", authorities=" + authorities +
				'}';
	}
}
