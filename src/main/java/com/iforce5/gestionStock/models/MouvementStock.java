package com.iforce5.gestionStock.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mouvementstock")
public class MouvementStock extends AbstractEntity{
     
	@Column(name = "code")
	private String code;
	
	@Column(name = "quantite")
	private BigDecimal quantite;
	
	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;
	
	//@Column(name = "typemvt")
	//private TypeMvtStk typeMvt;
	
	
}
