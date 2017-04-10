package net.mem.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	@Size(max=10)
	private String label;
	
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="FK_lieu")
	private Lieu lieu;
	
	@DecimalMin(value="0.50")
	private double prix;

	private String unite;
	private String img;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="FK_categorie")
	private Categorie categorie;

	
	@ManyToMany
	@JoinColumn (name="FK_allergene")
	private Collection<Allergene>allergene; 
	
	private int plu;
	



	public Produit() {
		super();
	}

	public Produit( String label, String nom, Lieu lieu, double prix, String unite, String photo,
			String description) {
		super();
		this.label = label;
		this.nom = nom;
		this.lieu = lieu;
		this.prix = prix;
		this.unite = unite;
		this.img = photo;
		this.description = description;
	}
	public Produit( String label, String nom, Lieu lieu, double prix, String unite, String photo,
			String description,Categorie categorie) {
		this(label,nom,lieu,prix,unite,photo,description);
		this.categorie=categorie;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public int getPlu() {
		return plu;
	}

	public void setPlu(int plu) {
		this.plu = plu;
	}

	public Collection<Allergene> getAllergene() {
		return allergene;
	}

	public void setAllergene(Collection<Allergene> allergene) {
		this.allergene = allergene;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", label=" + label + ", nom=" + nom + ", lieu=" + lieu + ", prix=" + prix
				+ ", unite=" + unite + ", img=" + img + ", description=" + description + ", categorie=" + categorie
				+ "]";
	}
	
	
}
