package app.iVoteHub.validators;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.iVoteHub.domain.User;
import app.iVoteHub.modelAttributes.LoginForm;
import app.iVoteHub.repositories.GeneralUserRepository;

public class UserLoginValidator implements Validator {

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
		LoginForm form = (LoginForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Name must not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "Username must not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password must not be empty.");
		
		User u = uRepo.findByUsername(form.getUsername());
		if (u == null) {
			errors.rejectValue("user", "", "Invalid username or password");
		} /*unspecific for security reasons - specifiy invalid or valid user would
		unkowningly give hackers knowledge of valid usernames */
		
		String uPassword = uRepo.findByUsername(form.getUsername()).getPassword();
		if (!form.getPassword().equals(uPassword)) {
			errors.rejectValue("user", "", "Invalid username or password.");
		}
	}
	
	
}
