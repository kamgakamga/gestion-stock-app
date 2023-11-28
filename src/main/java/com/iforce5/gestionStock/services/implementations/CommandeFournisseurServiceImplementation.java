package com.iforce5.gestionStock.services.implementations;

import com.iforce5.gestionStock.dto.CommandeFournisseurDto;
import com.iforce5.gestionStock.dto.LigneCommandeFournisseurDto;
import com.iforce5.gestionStock.exceptions.EntityNotFoundException;
import com.iforce5.gestionStock.exceptions.InvalidEntityException;
import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import com.iforce5.gestionStock.models.*;
import com.iforce5.gestionStock.repositories.*;
import com.iforce5.gestionStock.services.interfaces.CommandeFournisseurService;
import com.iforce5.gestionStock.validator.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImplementation implements CommandeFournisseurService {

    private final CommandeFournisseurRepository commandeFournisseurRepository;
    private final ArticleRepository articleRepository;
    private final FournisseurRepository fournisseurRepository;
    private final LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    public CommandeFournisseurServiceImplementation(CommandeFournisseurRepository commandeFournisseurRepository, ArticleRepository articleRepository, FournisseurRepository fournisseurRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.articleRepository = articleRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
    }


    @Override
    public CommandeFournisseurDto saveCommandeFournisseur(CommandeFournisseurDto commandeFournisseurDto) {
        CommandeFournisseur commandeFournisseurtToSave ;
        CommandeFournisseur  commandeFournisseurSaved ;
        List<String> errors = CommandeFournisseurValidator.validate(commandeFournisseurDto);
        List<String> articleErrors = new ArrayList<>();

        if(!errors.isEmpty()){
            log.error("Commande Fournisseur is not valid {} ",commandeFournisseurDto);
            throw new InvalidEntityException("La Commande Fournisseur n'est pas valide ", ErrosCodes.COMMANDE_FOURNISSEUR_INVALID,errors);
        }

   Fournisseur fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournisseurDto().getId()).orElseThrow(
                ()-> new EntityNotFoundException("Aucun client trouvé avec l'ID "+commandeFournisseurDto.getFournisseurDto().getId(),ErrosCodes.FOURNISSEUR_NOT_FOUND));


        commandeFournisseurDto.getLigneCommandeFournisseurDto().forEach(
                ligneCommandeFournisseurDto -> {
                    if(!Objects.isNull(ligneCommandeFournisseurDto.getArticleDto())){
                        Optional<Article> article = articleRepository.findById(ligneCommandeFournisseurDto.getArticleDto().getId());
                        if(!article.isPresent()){
                            articleErrors.add("L'article avec l'id "+ligneCommandeFournisseurDto.getArticleDto().getId()+" n'existe pas.");
                        }
                    } });
        if (!articleErrors.isEmpty()){
            log.warn("Liste des articles introuvable {} ", articleErrors);
            throw new InvalidEntityException("Article n'existe pas dans la base de donnée",ErrosCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        commandeFournisseurtToSave = CommandeFournisseurDto.commandeFounisseurDtoToCommandeFounisseur(commandeFournisseurDto,fournisseur) ;
        commandeFournisseurSaved = commandeFournisseurRepository.save(commandeFournisseurtToSave);

        commandeFournisseurDto.getLigneCommandeFournisseurDto().forEach(lcfd ->
        {
            LigneCommandeFournisseur ligneCommandeClient = LigneCommandeFournisseurDto.commandeFounisseurDtoToCommandeFounisseur(lcfd);
            ligneCommandeClient.setCommandeFournisseur(commandeFournisseurSaved);
            ligneCommandeFournisseurRepository.save(ligneCommandeClient);
        });

        return CommandeFournisseurDto.commandeFournisseurToCommandeFournisseurDto(commandeFournisseurSaved) ;
    }

    @Override
    public CommandeFournisseurDto findCommandeFournisseurById(Integer commandeFournisseurId) {
        if(commandeFournisseurId == null){
            log.error(" Commande Fournisseur ID is null");
            return  null;
        }
        CommandeFournisseur commandeFournisseur = commandeFournisseurRepository.findById(commandeFournisseurId).orElseThrow( ()-> new EntityNotFoundException("Aucun Commande Fournisseur trouvé avec l'id ="+commandeFournisseurId, ErrosCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
        return CommandeFournisseurDto.commandeFournisseurToCommandeFournisseurDto(commandeFournisseur) ;
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(!StringUtils.hasLength(code) ){
            log.error(" Commande Client Code is null");
            return  null;
        }
        CommandeFournisseur commandeFournisseur = commandeFournisseurRepository.findCommandeFournisseurByCode(code).orElseThrow( ()-> new EntityNotFoundException("Aucun Commande Fournisseur trouvé avec le code ="+code, ErrosCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
        return CommandeFournisseurDto.commandeFournisseurToCommandeFournisseurDto(commandeFournisseur) ;
    }

    @Override
    public List<CommandeFournisseurDto> getAllCommandeFournisseur() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::commandeFournisseurToCommandeFournisseurDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommandeFournisseur(Integer commandeFournisseurId) {
        commandeFournisseurRepository.deleteById(commandeFournisseurId);
    }
}
