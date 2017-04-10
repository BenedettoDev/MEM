package net.mem.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/Utilisateur")
public class UtilisateurController {
	
	@Autowired
	@RequestMapping(value="/Index")
	public String Index() {
		return "user/index";
	}
	
	@Autowired
	@RequestMapping(value="/Panier")
	public String panier() {
		return "user/panier/panier";
	}
	
}
