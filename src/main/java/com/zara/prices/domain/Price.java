package com.zara.prices.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BRAND_ID")
	private Brand brand;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "PRICE_LIST")
	private Integer priceListId;
	
	@Column( name = "PRODUCT_ID")
	private Integer productId;
	
	@Column( name = "PRIORITY")
	private Integer priority;
	
	@Column( name = "PRICE")
	private Double price;
	
	@Column (name = "CURR")
	private String currency;

}
