package VO;


public class state_vo {
	private int id;
	private String state;
	private String st_desc;
	country_vo cv;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSt_desc() {
		return st_desc;
	}
	public void setSt_desc(String st_desc) {
		this.st_desc = st_desc;
	}
	public country_vo getCv() {
		return cv;
	}
	public void setCv(country_vo cv) {
		this.cv = cv;
	}
	
	
}
