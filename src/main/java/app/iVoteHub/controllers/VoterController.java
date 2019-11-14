package app.iVoteHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoterController {

	
	@GetMapping("voter-main")
	public String voterHome() {
		return "voter-home";
	}
}
