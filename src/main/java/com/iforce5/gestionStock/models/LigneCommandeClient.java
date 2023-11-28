package com.iforce5.gestionStock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignecommandeclient")
public class LigneCommandeClient extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;
	@ManyToOne
	@JoinColumn(name = "id_commande_client")
	private CommandeClient commandeClient;
}
