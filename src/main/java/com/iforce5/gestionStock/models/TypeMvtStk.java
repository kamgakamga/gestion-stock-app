package com.iforce5.gestionStock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "typemvtstock")
public class TypeMvtStk {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

}
