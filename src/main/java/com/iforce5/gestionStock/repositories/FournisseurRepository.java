package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
