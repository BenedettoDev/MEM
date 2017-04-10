package net.mem.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String mail;
	private String nom;
	private String prenom;

	private String password;
	private boolean actived;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles;

	//Constructeurs
	public Utilisateur() {
		super();
	}

	public Utilisateur(String username, String password, boolean actived) {
		this.username = username;
		this.password = password;
		this.actived = actived;
	}
	
	public Utilisateur(String username, String mail, String nom, String prenom, String password, boolean actived,
			Collection<Role> roles) {
		this(username,password,actived);
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.roles = roles;
	}

	//Getters et setters
	


	public String getNom() {
		return nom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Utilisateur [username=" + username + ", mail=" + mail + ", nom=" + nom + ", prenom=" + prenom
				+ ", password=" + password + ", actived=" + actived + ", roles=" + roles + "]";
	}
}
