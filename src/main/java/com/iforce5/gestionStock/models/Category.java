package com.iforce5.gestionStock.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {
   
	@Column(name ="code" )
	private String code;
	
	@Column(name ="designation" )
	private String designation;
	
	@OneToMany(mappedBy = "category")
	private List<Article> articles;
	
}
