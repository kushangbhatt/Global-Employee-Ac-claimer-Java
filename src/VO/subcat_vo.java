package VO;

public class subcat_vo {
	private int id;
	private String subcat;
	private String desc;
	examtype_vo ev;
	cat_vo c;

	public examtype_vo getEv() {
		return ev;
	}
	public void setEv(examtype_vo ev) {
		this.ev = ev;
	}
		
	public cat_vo getC() {
		return c;
	}
	public void setC(cat_vo c) {
		this.c = c;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubcat() {
		return subcat;
	}
	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
