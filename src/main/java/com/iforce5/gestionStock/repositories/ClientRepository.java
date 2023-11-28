package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
