package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
      Optional<CommandeClient> findCommandeClientByCode(String code);
}
