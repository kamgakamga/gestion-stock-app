package com.iforce5.gestionStock.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.models.LigneVente;
import com.iforce5.gestionStock.models.MouvementStock;
import com.iforce5.gestionStock.models.TypeMvtStk;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MouvementStockDto {

	private Integer id;
	
	private String code;
	
	private BigDecimal quantite;
	
	@JsonIgnore
	private ArticleDto articleDto;
	
	@JsonIgnore
	private TypeMvtStkDto typeMvtDto;
	
	
	public MouvementStockDto fromEntity(MouvementStock mouvementStock) {
		if(mouvementStock == null) {
			return null;
		}
		return MouvementStockDto.builder()
				.id(mouvementStock.getId())
				.code(mouvementStock.getCode())
				.quantite(mouvementStock.getQuantite())
				.build();
	}
	

	public MouvementStock toDto(MouvementStockDto mouvementStockDto) {
		if(mouvementStockDto == null) {
			return null;
		}
		MouvementStock mouvementStock = new MouvementStock();
				    
		mouvementStockDto.setId(mouvementStockDto.getId()); 
		mouvementStockDto.setCode(mouvementStockDto.getCode());
		mouvementStockDto.setQuantite(mouvementStockDto.getQuantite());
		
	
				    return mouvementStock;
	}
	
	
}
