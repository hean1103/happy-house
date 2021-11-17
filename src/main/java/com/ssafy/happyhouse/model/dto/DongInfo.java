package com.ssafy.happyhouse.model.dto;


public class DongInfo {
	private String city;
	private String gugun;
	private String dong;
	
	public DongInfo(String city, String gugun, String dong) {
		super();
		this.city = city;
		this.gugun = gugun;
		this.dong = dong;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	@Override
	public String toString() {
		return "DongInfo [city=" + city + ", gugun=" + gugun + ", dong=" + dong + "]";
	}
	
	
	
	
	
	
	
}
