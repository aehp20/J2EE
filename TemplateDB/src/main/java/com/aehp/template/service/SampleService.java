package com.aehp.template.service;

import com.aehp.template.exception.InvalidUserException;
import com.aehp.template.model.SignupForm;

public interface SampleService {

	public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
