package com.reeza.userregistration.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

	
	  private final ConfirmationTokenRepository confirmationTokenRepository;
	  
	  public void saveConfirmationToken(ConfirmationToken token) {
	  confirmationTokenRepository.save(token); }
	  
	  public Optional<ConfirmationToken> getToken(String token){
	  
	  return confirmationTokenRepository.findByToken(token); }
	  
	  public int setConfirmedTime(String token) {
	  
	  return confirmationTokenRepository.updateConfirmationTime(token,
	  LocalDateTime.now()); }
	 
}
