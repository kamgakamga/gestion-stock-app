package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
