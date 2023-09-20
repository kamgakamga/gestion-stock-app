package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
}
