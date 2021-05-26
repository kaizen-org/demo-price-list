package com.zara.prices.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
	
	@Id
	private Long id;
	
	@NotNull
	private String name;

}
