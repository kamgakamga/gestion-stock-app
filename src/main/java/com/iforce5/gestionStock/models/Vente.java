package com.iforce5.gestionStock.models;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vente")
public class Vente extends AbstractEntity {
   
	@Column(name = "code")
	private String code;
	
	@Column(name = "date_vente")
	private Instant dateVente;
	
	@Column(name = "commentaire")
	private String commentaire;
}
