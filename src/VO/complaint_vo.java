package VO;

public class complaint_vo {
	private int id;
	private String desc;
	private String sub;
	private String type;
	private emp_dtl_vo emp;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public emp_dtl_vo getEmp() {
		return emp;
	}
	public void setEmp(emp_dtl_vo emp) {
		this.emp = emp;
	}
}
