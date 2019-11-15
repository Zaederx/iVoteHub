package app.iVoteHub.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.iVoteHub.addressEnums.VoterAddress;
import app.iVoteHub.domain.Voter;

/**
 * A controller for all the voter pages.
 * 
 * Controller addresses should correspond to 
 * VoterAddress enum - which acts should act as
 * an authority on matters of url / domain addresses.
 * 
 * @author Zachary Ishmael
 *
 */
@Controller
@RequestMapping("voter/")
public class VoterController {


	@GetMapping("voter-main")
	public String voterHome() {
		return "voter/voter-home";
	}
	
	@GetMapping("/vote")
	public String vote(@ModelAttribute("voter") Voter voter) {
		
		if (voter.hasVoted()) {
			return "redirect:voter/voter-main?voted=true";//forward?
		} else {
			return "redirect:"+VoterAddress.VOTE.jsp();
		}
		
	}
	
	
	
}
