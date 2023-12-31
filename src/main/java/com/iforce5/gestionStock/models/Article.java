package com.iforce5.gestionStock.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder// c'est une classe qui permet de construis un objet en exposant des methodes ayant les memes nom d'attributs ayant une methode build qui construis un objet a parti des objets passé en argument 
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class Article  extends AbstractEntity{

	@Column(name = "code_article")
	private String codeArticle;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "prix_unitaire")
	private BigDecimal prixUnitaire;
	
	@Column(name = "taux_tva")
	private BigDecimal tauxTva;
	
	@Column(name = "prix_unitaire_ttc")
	private BigDecimal prixUnitaireTTC;
	
	@Column(name = "photo")
 	private String photo;
	
	@JoinColumn(name = "id_category")
 	private Category category; 
}
