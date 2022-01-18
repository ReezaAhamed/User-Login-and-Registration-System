package com.reeza.userregistration.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String email) {
		// TODO Auto-generated method stub
		return true;
	}

}
