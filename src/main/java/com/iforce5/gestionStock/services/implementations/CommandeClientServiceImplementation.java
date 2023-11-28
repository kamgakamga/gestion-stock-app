package com.iforce5.gestionStock.services.implementations;

import com.iforce5.gestionStock.dto.CommandeClientDto;
import com.iforce5.gestionStock.dto.LigneCommandeClientDto;
import com.iforce5.gestionStock.exceptions.EntityNotFoundException;
import com.iforce5.gestionStock.exceptions.InvalidEntityException;
import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.models.Client;
import com.iforce5.gestionStock.models.CommandeClient;
import com.iforce5.gestionStock.models.LigneCommandeClient;
import com.iforce5.gestionStock.repositories.ArticleRepository;
import com.iforce5.gestionStock.repositories.ClientRepository;
import com.iforce5.gestionStock.repositories.CommandeClientRepository;
import com.iforce5.gestionStock.repositories.LigneCommandeClientRepository;
import com.iforce5.gestionStock.services.interfaces.CommandeClientService;
import com.iforce5.gestionStock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImplementation implements CommandeClientService {

    private final CommandeClientRepository commandeClientRepository;
    private final ArticleRepository articleRepository;
    private final ClientRepository clientRepository;
    private final LigneCommandeClientRepository ligneCommandeClientRepository;

    public CommandeClientServiceImplementation(CommandeClientRepository commandeClientRepository, ArticleRepository articleRepository, ClientRepository clientRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.articleRepository = articleRepository;
        this.clientRepository = clientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandeClientDto saveCommandeClient(CommandeClientDto commandeClientDto) {
        CommandeClient commandeClientToSave ;
        CommandeClient  commandeClientSaved ;
        List<String> errors = CommandeClientValidator.validate(commandeClientDto);
        List<String> articleErrors = new ArrayList<>();

        if(!errors.isEmpty()){
            log.error("Commande Client is not valid {} ",commandeClientDto);
            throw new InvalidEntityException("La Commande Client n'est pas valide ", ErrosCodes.COMMANDE_CLIENT_INVALID,errors);
        }

            Client client = clientRepository.findById(commandeClientDto.getClientDto().getId()).orElseThrow(
                    ()-> new EntityNotFoundException("Aucun client trouvé avec l'ID "+commandeClientDto.getClientDto().getId(),ErrosCodes.CLIENT_NOT_FOUND));


            commandeClientDto.getLigneCommandeClientDto().forEach(
                    ligneCommandeClientDto -> {
                        if(!Objects.isNull(ligneCommandeClientDto.getArticleDto())){
                            Optional<Article> article = articleRepository.findById(ligneCommandeClientDto.getArticleDto().getId());
                            if(!article.isPresent()){
                                articleErrors.add("L'article avec l'id "+ligneCommandeClientDto.getArticleDto().getId()+" n'existe pas.");
                            }
                        } });
        if (!articleErrors.isEmpty()){
            log.warn("Liste des articles introuvable {} ", articleErrors);
            throw new InvalidEntityException("Article n'existe pas dans la base de donnée",ErrosCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        commandeClientToSave = CommandeClientDto.commandeClientDtoTocommandeClient(commandeClientDto,client) ;
        commandeClientSaved = commandeClientRepository.save(commandeClientToSave);

            commandeClientDto.getLigneCommandeClientDto().forEach(lccd ->
            {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.LigneCommandeClientDtoToLigneCommandeClient(lccd);
                ligneCommandeClient.setCommandeClient(commandeClientSaved);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });

        return CommandeClientDto.commandeClientTocommandeClientDto(commandeClientSaved) ;
    }

    @Override
    public CommandeClientDto findCommandeClientById(Integer commandeClientId) {
        if(commandeClientId == null){
            log.error(" Commande Client ID is null");
            return  null;
        }
        CommandeClient commandeClient = commandeClientRepository.findById(commandeClientId).orElseThrow( ()-> new EntityNotFoundException("Aucun Commande Client trouvé avec l'id ="+commandeClientId, ErrosCodes.COMMANDE_CLIENT_NOT_FOUND));
        return CommandeClientDto.commandeClientTocommandeClientDto(commandeClient) ;
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(!StringUtils.hasLength(code) ){
            log.error(" Commande Client Code is null");
            return  null;
        }
        CommandeClient commandeClient = commandeClientRepository.findCommandeClientByCode(code).orElseThrow( ()-> new EntityNotFoundException("Aucun Commande Client trouvé avec le code ="+code, ErrosCodes.COMMANDE_CLIENT_NOT_FOUND));
        return CommandeClientDto.commandeClientTocommandeClientDto(commandeClient) ;
    }

    @Override
    public List<CommandeClientDto> getAllCommandeClient() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::commandeClientTocommandeClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommandeClient(Integer commandeClientId) {
             commandeClientRepository.deleteById(commandeClientId);
    }
}
