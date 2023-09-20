package com.iforce5.gestionStock.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity {

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
	
	@Column(name="motdepasse")
	private String motDePasse;
	@Column(name = "datedenaissance")
 	private Instant dateDeNaissance;
	
	@Embedded//permet de definir une relation de composition
	private Adresse adresse;
    
	@ManyToOne
	@JoinColumn(name = "identreprise")
 	private Entreprise entreprise;
	
	@OneToMany(mappedBy = "utilisateur")
 	private List<Roles> roles;
	
}
