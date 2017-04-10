package net.mem.web;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.mem.dao.UtilisateurRepository;
import net.mem.entities.Role;
import net.mem.entities.Utilisateur;

@Controller
public class HomeController {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
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
	
	@RequestMapping(value={"/Inscription"})
	public String inscription(Model model) {
		model.addAttribute("utilisateur",new Utilisateur());
		return "inscription";
	}
	
	@RequestMapping(value="/SaveUtilisateur",method=RequestMethod.POST)
	public String saveUtilisateur(Utilisateur utilisateur){
		System.out.println(utilisateur.toString());
		utilisateur.setActived(true);
		Collection<Role> role = new ArrayList<Role>();
		role.add(new Role("USER","Utilisateur"));
		utilisateur.setRoles(role);
		utilisateurRepository.save(utilisateur);
		return "index";
	}
}
