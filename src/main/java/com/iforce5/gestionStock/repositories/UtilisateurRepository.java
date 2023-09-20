package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
