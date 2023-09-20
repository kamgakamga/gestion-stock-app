package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Utilisateur;
import com.iforce5.gestionStock.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Long> {
}
