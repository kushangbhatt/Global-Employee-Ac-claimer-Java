package VO;

import DAO.state_dao;

public class city_vo {
	private int id;
	private  String city;
	private String ct_desc;
	state_vo sv;	
	country_vo cv;
	
	
	
	public country_vo getCv() {
		return cv;
	}
	public void setCv(country_vo cv) {
		this.cv = cv;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCt_desc() {
		return ct_desc;
	}
	public void setCt_desc(String ct_desc) {
		this.ct_desc = ct_desc;
	}
	public state_vo getSv() {
		return sv;
	}
	public void setSv(state_vo sv) {
		this.sv = sv;
	}

}
