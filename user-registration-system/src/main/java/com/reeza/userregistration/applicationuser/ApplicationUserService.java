package com.reeza.userregistration.applicationuser;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import com.reeza.userregistration.registration.token.ConfirmationToken;
//import com.reeza.userregistration.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

	private final ApplicationUserRepository appUserRepository;
	private static final String userNotFoundMessage = "User with the email '%s' not found!";
	
	private final BCryptPasswordEncoder bCryptPasswordEcoder;
	//private final ConfirmationTokenService confirmationTokenService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return appUserRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(userNotFoundMessage, email)));
	}
	
	public String signUpUser(ApplicationUser appUser) {
		
		boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
		
		if(userExists) {
			throw new IllegalStateException("Email is already registered");
		}
		
		String encodedPassword = bCryptPasswordEcoder.encode(appUser.getPassword());
		
		appUser.setPassword(encodedPassword);
		
		appUserRepository.save(appUser);
		
		
		  //Send Confirmation Token String token = UUID.randomUUID().toString();
		  ConfirmationToken confirmationToken = new ConfirmationToken(token,
		  LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser);
		  
		  confirmationTokenService.saveConfirmationToken(confirmationToken);
		  
		  // Send email
		 		
		return "Works";
	}
	
	
	  public int enableAppUser(String email) {
	  
	  return appUserRepository.enableAppUser(email); }
	 

}
