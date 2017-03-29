package net.mem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mem.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
