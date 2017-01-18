package net.isfce.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.isfce.dao.CategorieRepository;
import net.isfce.dao.LieuRepository;
import net.isfce.dao.ProduitRepository;
import net.isfce.entities.Categorie;
import net.isfce.entities.Lieu;
import net.isfce.entities.Produit;


@Controller
@RequestMapping(value="/Admin/Produit")
public class AdminProduitController {
	@Autowired 
	private ProduitRepository produitRepository;
	
	@Autowired
	private LieuRepository lieuRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@RequestMapping(value="/Index")
	public String Index(Model model,@RequestParam(name="page",defaultValue="0")int p,@RequestParam(name="motCle",defaultValue="")String mc){
		Page<Produit> pageProd =  produitRepository.chercherProduits("%"+mc+"%",new PageRequest(p, 5));
		
		int pageCount = pageProd.getTotalPages();
		int []pages=new int[pageCount];
		for(int i=0;i<pageCount;i++)pages[i]=i;
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante",p);
		model.addAttribute("pageProduits",pageProd);
		model.addAttribute("titre","Produits");
		model.addAttribute("motCle",mc);
		return "admin/produit";
	}
	
	@RequestMapping(value="/Form",method=RequestMethod.GET)
	public String formProduit(Model model) {
		List <Lieu> lieux = lieuRepository.findAll();
		List <Categorie> categories = categorieRepository.findAll();
		Map<String, String> unites = (Map<String, String>) new HashMap<String,String>();
		unites.put("Pce","Pièce");
		unites.put("Kg","Kilogramme");
		unites.put("G","Gramme");
		unites.put("Cl", "Centilitre");
		unites.put("Ml", "Millilitre");
		
		model.addAttribute("lieux", lieux);
		model.addAttribute("unites", unites);
		model.addAttribute("categories",categories);
		model.addAttribute("produit",new Produit());
		return "admin/formProduit";
	}
	
	@RequestMapping(value="SaveProduit",method=RequestMethod.POST)
	public String save(@Valid Produit prod, BindingResult bindingResult){
		String []prodLieu = prod.getLieu().split(",");

		if (prodLieu[0].equals("Autre")){
			prod.setLieu(prodLieu[prodLieu.length-1]);
			lieuRepository.save(new Lieu(prod.getLieu()));
		}
		String [] prodCat = prod.getCategorie().split(",");
		if (prodCat[0].equals("Autre")){
			prod.setCategorie(prodCat[prodCat.length-1]);
			categorieRepository.save(new Categorie(prod.getCategorie()));
		}
		
		if (bindingResult.hasErrors()){
			return "admin/formProduit";
		}
				
		produitRepository.save(prod);
		return "redirect:Index";
	}
	
	@RequestMapping(value="Supprimer")
	public String delete(Long id) {
		produitRepository.delete(id);
		 return "redirect:Index";
	}
	
	@RequestMapping(value="Editer")
	public String edit(Long id,Model model){
		List <Lieu> lieux = lieuRepository.findAll();
		List <Categorie> categories = categorieRepository.findAll();				
		Map<String, String> unites = (Map<String, String>) new HashMap<String,String>();
		unites.put("Pce","Pièce");
		unites.put("Kg","Kilogramme");
		unites.put("G","Gramme");
		unites.put("Cl", "Centilitre");
		unites.put("Ml", "Millilitre");
		
		Produit prod = produitRepository.getOne(id);
		model.addAttribute("produit",prod);
		model.addAttribute("lieux",lieux);
		model.addAttribute("unites",unites);
		model.addAttribute("categories",categories);
		return "admin/EditProduit";

	}
	
	@RequestMapping(value="Update",method=RequestMethod.POST)
	public String update(@Valid Produit prod, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "admin/EditProduit";
		}
		produitRepository.save(prod);
		 return "redirect:Index";
	}
	
	
	//Unité
	
	
	
}
