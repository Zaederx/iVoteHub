package app.iVoteHub.validators;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.iVoteHub.domain.User;
import app.iVoteHub.modelAttributes.LoginForm;
import app.iVoteHub.repositories.GeneralUserRepository;

public class UserLoginValidator implements Validator {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	private GeneralUserRepository uRepo;
	
	public UserLoginValidator(GeneralUserRepository uRepo) {
		this.uRepo = uRepo;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Performing User Login Form Validations");
		LoginForm form = (LoginForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "Username must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password must not be empty.");
		
		boolean safeUser = true;
		User u = null;
		try {
			u = uRepo.findByUsername(form.getUsername());
		} catch (NullPointerException e) {
			safeUser = false;
		}catch (Exception e) {
			safeUser = false;
		}
		
		if (u == null) {
			errors.rejectValue("username", "", "Invalid username.");
			errors.rejectValue("password", "", "No valid user was given to check password.");
			safeUser = false;
		}
		/*Done this way for purposes of the assignment, but 
		would be better to use unspecific error messages for security reasons - specifying invalid or valid user would
		unkowningly give hackers knowledge of valid usernames 
		*/
		if (safeUser) {
			boolean safeString = true;
			String uPassword = "";
			try {
			uPassword= u.getPassword();
			} catch (NullPointerException e) {
				errors.rejectValue("password", "", "Invalid password.");
				safeString = false;
			}
			
			if (safeString == true && !encoder.matches(form.getPassword(), uPassword)) {
				errors.rejectValue("password", "", "Invalid password.");
			}
		}
	}
}
