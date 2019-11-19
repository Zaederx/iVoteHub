package app.iVoteHub.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.iVoteHub.domain.SNI;
import app.iVoteHub.modelAttributes.VoterRegForm;
import app.iVoteHub.repositories.SNIRepository;


public class VoterRegFormValidator implements Validator {
	

	private SNIRepository sRepo;
	
	public VoterRegFormValidator(SNIRepository sRepo) {
		this.sRepo = sRepo;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return VoterRegForm.class.equals(clazz);
	}

	//TODO - Autowiring or method needed ?? 
	@Override
	public void validate(Object target, Errors errors) {
		VoterRegForm form = (VoterRegForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","", "Name must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","" , "Username must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Email must not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "","Password must not be empty");
		
		
		if(!form.getPassword().equals(form.getPassword2())) {
			errors.rejectValue("password", "","Passwords do not match");
		}
		SNI s = sRepo.findBySniCode(form.getSniCode());
		
		if (s == null || s.getUsed() == true) {
			errors.rejectValue("sniCode", "", "Invalid SNI.");
		}
	}

}
