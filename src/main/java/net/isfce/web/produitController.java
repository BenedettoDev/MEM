package net.isfce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.isfce.dao.CategorieRepository;
import net.isfce.dao.ProduitRepository;
import net.isfce.entities.Produit;

@Controller
@RequestMapping(value = "/Produit")
public class produitController {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;

	@RequestMapping(value = "/Index")
	public String Index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motCle", defaultValue = "") String mc,
			@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "cat", defaultValue = "") String categorie) {

		if (id != null) {
			Produit produit = produitRepository.findOne(id);
			if (produit == null)
				return "redirect:Index";
			model.addAttribute("produit", produit);
			return "single-produit";
		}

		Page<Produit> pageProd = null;
//		if (categorie != null) {
//			pageProd = produitRepository.chercherProduitsByCategory(categorie, new PageRequest(p, 5));
//		}

		if (mc != null) {
			pageProd = produitRepository.chercherProduits("%" + mc + "%", new PageRequest(p, 5));
		}
		int pageCount = pageProd.getTotalPages();
		int[] pages = new int[pageCount];
		for (int i = 0; i < pageCount; i++)
			pages[i] = i;

		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("pageProduits", pageProd);
		model.addAttribute("titre", "Produits");
		model.addAttribute("motCle", mc);
		model.addAttribute("categories", categorieRepository.findAll());

		return "produit";
	}
}
