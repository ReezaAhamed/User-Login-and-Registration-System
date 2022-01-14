package com.reeza.userregistration.registration;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reeza.userregistration.applicationuser.ApplicationUser;
import com.reeza.userregistration.applicationuser.ApplicationUserRole;
import com.reeza.userregistration.applicationuser.ApplicationUserService;
import com.reeza.userregistration.registration.token.ConfirmationToken;
import com.reeza.userregistration.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
	
	private final ApplicationUserService appUserService; 
	private final EmailValidator emailValidator;
	private final ConfirmationTokenService confirmationTokenService; 
	
	public String register(RegistrationRequest request){
		
		boolean isValidEmail = emailValidator.test(request.getEmail());
		
		if(!isValidEmail) {
			throw new IllegalStateException(String.format("Email '%s' not valid!", request.getEmail())); 
		}
		
		return appUserService.signUpUser(new ApplicationUser(request.getFirstName(), request.getLastName(), 
												request.getEmail(), request.getPassword(), ApplicationUserRole.USER));
		
	}
	
	/*
	 * @Transactional public String confirmToken(String token) { ConfirmationToken
	 * confirmationToken = confirmationTokenService .getToken(token) .orElseThrow(()
	 * -> new IllegalStateException("token not found"));
	 * 
	 * if (confirmationToken.getConfirmedTime() != null) { throw new
	 * IllegalStateException("email already confirmed"); }
	 * 
	 * LocalDateTime expirationTime = confirmationToken.getExpirationTime();
	 * 
	 * if (expirationTime.isBefore(LocalDateTime.now())) { throw new
	 * IllegalStateException("token expired"); }
	 * 
	 * confirmationTokenService.setConfirmedTime(token);
	 * appUserService.enableAppUser( confirmationToken.getAppUser().getEmail());
	 * return "confirmed"; }
	 */

}
