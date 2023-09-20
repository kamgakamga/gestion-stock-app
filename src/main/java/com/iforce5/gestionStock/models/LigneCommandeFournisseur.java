package com.iforce5.gestionStock.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {

	 @ManyToOne
	 @JoinColumn(name = "idarticle")
     private Article article;
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "idcommandefournisseur")
     private CommandeFounisseur commandeFournisseur;

}
