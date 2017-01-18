package net.isfce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.isfce.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
