package com.om.hib.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "helicopter_table")
public class HelicopterDTO {
	@Id
	@GenericGenerator(name="ref",strategy="increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "h_id")
	private int hId;
	@Column(name = "h_name")
	private String hName;
	@Column(name = "h_countryname")
	private String hCountryName;
	@Column(name = "h_price")
	private double hPrice;

	public HelicopterDTO() {
		System.out.println("HelicopterDTO created.");
	}

	public int getHId() {
		return hId;
	}

	public void setHId(int hId) {
		this.hId = hId;
	}

	public String getHName() {
		return hName;
	}

	public void setHName(String hName) {
		this.hName = hName;
	}

	public String gethCountryName() {
		return hCountryName;
	}

	public void sethCountryName(String hCountryName) {
		this.hCountryName = hCountryName;
	}

	public double gethPrice() {
		return hPrice;
	}

	public void sethPrice(double hPrice) {
		this.hPrice = hPrice;
	}

	@Override
	public String toString() {
		return "#####>>>HelicopterDTO [hId=" + hId + ", hName=" + hName
				+ ", hCountryName=" + hCountryName + ", hPrice=" + hPrice + "]";
	}

}
