package com.reeza.userregistration.registration.token;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.reeza.userregistration.applicationuser.ApplicationUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="confirmation_token")*/
public class ConfirmationToken {
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name ="id") private int id;
	 * 
	 * @Column(name="token", nullable = false) private String token;
	 * 
	 * @Column(name="created_time", nullable = false) private LocalDateTime
	 * createdTime;
	 * 
	 * @Column(name="expired_time", nullable = false) private LocalDateTime
	 * expirationTime; // we set
	 * 
	 * @Column(name="confirmed_time") private LocalDateTime confirmedTime;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn ( nullable = false, name = "app_user_id" ) private
	 * ApplicationUser appUser;
	 * 
	 * 
	 * public ConfirmationToken(String token, LocalDateTime createdTime,
	 * LocalDateTime expirationTime, ApplicationUser appUser) { super(); this.token
	 * = token; this.createdTime = createdTime; this.expirationTime =
	 * expirationTime; this.appUser = appUser; }
	 */
	
	

}
