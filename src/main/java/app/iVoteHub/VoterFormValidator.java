package app.iVoteHub;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import app.iVoteHub.modelAttributes.VoterRegForm;

public class VoterFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return VoterRegForm.class.equals(clazz);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
//		VoterRegForm form = (Voter)
	}

}
