package com.iforce5.gestionStock.services.interfaces;

import com.iforce5.gestionStock.dto.CommandeClientDto;
import com.iforce5.gestionStock.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto saveCommandeFournisseur(CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseurDto findCommandeFournisseurById(Integer commandeFournisseurId);
    CommandeFournisseurDto findByCode(String code);
    List<CommandeFournisseurDto> getAllCommandeFournisseur();
    void deleteCommandeFournisseur(Integer commandeFournisseurId);
}
