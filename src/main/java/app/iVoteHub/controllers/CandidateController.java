package app.iVoteHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.iVoteHub.addressEnums.CAddressBook;

@Controller
@RequestMapping("candidate/")
public class CandidateController {

	@GetMapping("home")
	public String candidateHome() {
		return CAddressBook.C_HOME.jsp();
	}
}
