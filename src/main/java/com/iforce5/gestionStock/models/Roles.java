package com.iforce5.gestionStock.models;

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
@Table(name = "roles")
public class Roles extends AbstractEntity {

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "role_description")
	private String roleDescription;
	 
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
}
