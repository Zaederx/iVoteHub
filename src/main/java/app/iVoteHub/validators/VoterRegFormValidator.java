package app.iVoteHub.validators;

import java.util.regex.Pattern;

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
		
		/*Check if fields are empty*/
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
	
		/*USERNAME MUST NOT BE USED BY ANOTEHR VOTER*/
		if(u != null) {errors.rejectValue("username", "", "Username is already in use.");}
		
		Voter v = null;
		
		/*Check that email matches standard email regex pattern.*/
		String emailPattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
		boolean matches = Pattern.matches(emailPattern, form.getEmail()); 		
		if (!matches) {
			errors.rejectValue("email", "", "Invalid Email: Email does not match standard email pattern.");
		}
		
		/*email must not be in use by another VOTER*/
		try {
			v = vRepo.findByEmail(form.getEmail());
		} catch (NullPointerException e) {
			System.out.println("catch1: email safe for use.");
		} catch (Exception e) {
			System.out.println("catch 2: email safe for use.");
		}
		
		if (v != null) {errors.rejectValue("email", "", "Email is already in use.");}
		
		/*Password must be checked against standard  password regex pattern */
		String passwordPattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
		boolean pMatches = Pattern.matches(passwordPattern, form.getPassword());
		
		if (!pMatches) {
			errors.rejectValue("password", "", "Invalid Password: Passoword must be 8 characters long, have at least 1 number, 1 uppercase letter, 1 lowercase lettter.");
		}
		
		//TODO - Add extra specific password check - separate for legnth and content
				
		/* password 1 and 2 must match */
		if(!form.getPassword().equals(form.getPassword2())) {
			errors.rejectValue("password", "","Passwords do not match.");
		}
		SNI s = sRepo.findBySniCode(form.getSniCode());
		
		if (s == null || s.getUsed() == true) {
			errors.rejectValue("sniCode", "", "Invalid SNI.");
		}
	}

}
