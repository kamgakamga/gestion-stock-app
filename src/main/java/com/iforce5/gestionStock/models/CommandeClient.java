package com.iforce5.gestionStock.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commandeclient")
public class CommandeClient extends AbstractEntity {

	@Column(name = "code")
	private String code;
	
	@Column(name = "date_commande")
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClient;
}
