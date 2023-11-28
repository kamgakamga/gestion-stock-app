package com.iforce5.gestionStock.services.interfaces;

import com.iforce5.gestionStock.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto saveCommandeClient(CommandeClientDto commandeClientDto);
    CommandeClientDto findCommandeClientById(Integer commandeClientId);
    CommandeClientDto findByCode(String code);
    List<CommandeClientDto> getAllCommandeClient();
    void deleteCommandeClient(Integer commandeClientId);
}
