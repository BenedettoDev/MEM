package net.isfce.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/Commande")
public class CommandeController {

	@RequestMapping(value="/Index")
	public String Index(){
		return "Commande";
	}
	
}
