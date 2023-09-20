package com.iforce5.gestionStock.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fournisseur")
public class Fournisseur extends AbstractEntity{

	@Column(name = "nom")
 	private String nom;
	
	@Column(name = "prenom")
 	private String prenom;
	
	@Column(name = "photo")
 	private String photo;
	
	@Column(name = "email")
 	private String email;
	
	@Column(name = "numtel")
 	private String numTel;
	
	
	@Embedded//permet de definir une relation de composition
	private Adresse adresse;
	
	@OneToMany(mappedBy = "fournisseur")
 	private List<CommandeFounisseur> commandeFounisseur;

	
}
