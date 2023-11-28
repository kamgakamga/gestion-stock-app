package com.iforce5.gestionStock.models;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commande_founisseur")
public class CommandeFournisseur extends AbstractEntity{

	@Column(name = "code")
	private String code;
	
	@Column(name = "date_commande")
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name = "id_fournisseur")
	private Fournisseur fournisseur;
	
    @OneToMany(mappedBy = "commandeFournisseur")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseur;
}
