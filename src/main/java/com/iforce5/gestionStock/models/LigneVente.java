package com.iforce5.gestionStock.models;

import java.math.BigDecimal;

import javax.persistence.Column;
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
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity {
  
	@ManyToOne
	@JoinColumn(name = "id_vente")
	private Vente vente;
	
	@Column(name = "quantite")
	private BigDecimal quantite;
	
	
}
