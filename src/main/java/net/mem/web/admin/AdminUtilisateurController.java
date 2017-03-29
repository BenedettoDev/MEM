package net.mem.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/Admin/Utilisateur")
public class AdminUtilisateurController {

//	@Autowired
//	private UtilisateurRepository utilisateurRepository;

//	@RequestMapping(value = "/Index")
//	public String Index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
//			@RequestParam(name = "motCle", defaultValue = "") String mc) {
////		Page<Utilisateur> pageUser = utilisateurRepository.chercherU²("%" + mc + "%", new PageRequest(p, 5));
//
//		int pageCount = pageUser.getTotalPages();
//		int[] pages = new int[pageCount];
//		for (int i = 0; i < pageCount; i++)
//			pages[i] = i;
//		model.addAttribute("pages", pages);
//		model.addAttribute("pageCourante", p);
//		model.addAttribute("pageUtilisateurs", pageUser);
//		model.addAttribute("titre", "Utilisateur");
//		model.addAttribute("motCle", mc);
//		return "admin/utilisateur";
//	}
}
