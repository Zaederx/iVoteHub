package app.iVoteHub.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class iVoteErrorController implements ErrorController{

	// @Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping("/error")
	public String defaultError(HttpServletRequest request) {
	System.out.println("defaultError page");
	Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

	if (status !=null) {
		Integer statusInteger = Integer.valueOf(status.toString());
		if (statusInteger == HttpStatus.NOT_FOUND.value()) {
			return "error-lost-user";//404
		}
		
		if (statusInteger == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			return "error-sorry";//500
		}
	}
	return "error-default";
	}
	

}
