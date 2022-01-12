package com.reeza.userregistration.applicationuser;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name="application_user")
public class ApplicationUser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="emal")
	private String email;
	
	//@Column(name="username") we are working with email, not username
	//private String username;
	
	@Column(name="pass_word")
	private String password;
	
	@Column(name="app_user_role")
	@Enumerated(EnumType.STRING)
	private ApplicationUserRole appUserRole;
	
	@Column(name="lock_ed")
	private boolean locked = false; //setting defaults
	
	@Column(name="enabled")
	private boolean enabled = false; //setting defaults
	
	public ApplicationUser(String firstName, String lastName, String email, String password,
			ApplicationUserRole appUserRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.username = username;
		this.password = password;
		this.appUserRole = appUserRole;
		//this.locked = locked;
		//this.enabled = enabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
		
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return email; //remember we're working with email
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return enabled;
	}

}
