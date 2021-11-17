package com.ssafy.happyhouse.model.dto;

import java.sql.Date;

public class HouseInfo {
	
	private String AptName,dealAmount,area,dealYear;

	
	public HouseInfo() {
	}

	public HouseInfo(String aptName, String dealAmount, String area, String dealYear) {
		AptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.dealYear = dealYear;
	}

	public String getAptName() {
		return AptName;
	}

	public void setAptName(String aptName) {
		AptName = aptName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDealYear() {
		return dealYear;
	}

	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	
	
}
