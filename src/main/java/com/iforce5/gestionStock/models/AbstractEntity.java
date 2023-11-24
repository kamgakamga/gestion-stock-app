package com.iforce5.gestionStock.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass //permet de consideré cette classe comme étant une super classe afin que ces attributs soit injecté dans toute les autres classes.
@EntityListeners(AuditingEntityListener.class)//cette annotation permet d'ecouter automatiquement la classe afin de gere de façon automatique la creation et la modificationde des champs createdAt et updatedAt 
public class AbstractEntity implements Serializable{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@CreatedDate
	@JsonIgnore
	@Column(name="createdAt", nullable=false)
	private Date createdAt;
	
	@LastModifiedDate
	@JsonIgnore
	@Column(name="updatedAt")
	private Date updatedAt;
	
}
