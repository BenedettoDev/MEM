package net.isfce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produit implements Serializable {

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
	private String photo;
	
	private String description;
	
	private String categorie;



	public Produit() {
		super();
	}

	public Produit(Long id, String label, String nom, Lieu lieu, double prix, String unite, String photo,
			String description) {
		super();
		this.id = id;
		this.label = label;
		this.nom = nom;
		this.lieu = lieu;
		this.prix = prix;
		this.unite = unite;
		this.photo = photo;
		this.description = description;
	}
	public Produit(Long id, String label, String nom, Lieu lieu, double prix, String unite, String photo,
			String description,String categorie) {
		this(id,label,nom,lieu,prix,unite,photo,description);
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
}
