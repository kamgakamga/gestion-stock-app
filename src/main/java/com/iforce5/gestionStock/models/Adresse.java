package com.iforce5.gestionStock.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@Embeddable
//@Entity
//@Table(name = "adresse")
public class Adresse {
 
	@Column(name = "adresse1")
	private String adresse1;
	
	@Column(name = "adresse2")
	private String adresse2;
	
	@Column(name = "ville")
	private String ville;
	
	@Column(name = "code_postale")
	private String codePostale;
	
	@Column(name = "pays")
	private String pays;
}
