package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {
}
