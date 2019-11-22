package app.iVoteHub.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.iVoteHub.domain.SNI;
import app.iVoteHub.domain.User;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.modelAttributes.VoterRegForm;
import app.iVoteHub.repositories.GeneralUserRepository;
import app.iVoteHub.repositories.SNIRepository;
import app.iVoteHub.repositories.VoterRepository;


public class VoterRegFormValidator implements Validator {
	

	private SNIRepository sRepo;
	private GeneralUserRepository uRepo;
	private VoterRepository vRepo;
	
	public VoterRegFormValidator(SNIRepository sRepo, GeneralUserRepository uRepo, VoterRepository vRepo) {
		this.sRepo = sRepo;
		this.uRepo = uRepo;
		this.vRepo = vRepo;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return VoterRegForm.class.equals(clazz);
	}


	@Override
	public void validate(Object target, Errors errors) {
		VoterRegForm form = (VoterRegForm) target;
		
		//Check if fields are empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","", "Name must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","" , "Username must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Email must not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "","Password must not be empty");
	
		
		
		User u = null;
		try {
		u = uRepo.findByUsername(form.getUsername());
		} catch (NullPointerException e) {
			System.out.println("catch 1: Username is free for use");
		}
		catch (Exception e) {
			System.out.println("catch 2: Username is free for use");
		}
	
		//USERNAME MUST NOT BE USED BY ANOTEHR VOTER
		if(u != null) {errors.rejectValue("username", "", "Username is already in use.");}
		
		Voter v = null;
		
		//email must not be in use by another VOTER
		try {
			v = vRepo.findByEmail(form.getEmail());
		} catch (NullPointerException e) {
			System.out.println("catch1: email safe for use.");
		} catch (Exception e) {
			System.out.println("catch 2: email safe for use.");
		}
		
		if (v != null) {errors.rejectValue("email", "", "Email is already in use.");}
		// TODO - password must meet regex - can do that from the fron end as well perhaps?? 
				
		// password 1 and 2 must match
		if(!form.getPassword().equals(form.getPassword2())) {
			errors.rejectValue("password", "","Passwords do not match.");
		}
		SNI s = sRepo.findBySniCode(form.getSniCode());
		
		if (s == null || s.getUsed() == true) {
			errors.rejectValue("sniCode", "", "Invalid SNI.");
		}
	}

}
