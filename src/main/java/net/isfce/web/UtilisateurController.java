package net.isfce.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilisateurController {
//	@Autowired
//	private UtilisateurRepository utilisateurRepository;
	
	@RequestMapping(value={"/Index","/"})
	public String home() {
		return "index";
	}
	
	@RequestMapping("/Login")
	public String login () {
		return "login";
	}
	
	@RequestMapping("/Logout")
	public String logout() {
		return "logout";
	}
}
