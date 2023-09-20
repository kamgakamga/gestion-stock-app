package com.iforce5.gestionStock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iforce5.gestionStock.models.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {
}
