package app.iVoteHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("voter")
public class VoterController {

	
	@GetMapping("/home")
	public String voterHome() {
		return "voter-home";
	}
}
