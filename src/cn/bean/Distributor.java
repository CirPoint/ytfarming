package cn.bean;

public class Distributor {
	private int id;
	private String identity;
	private String password;
	private String name;
	private String address;
	private String information;
	private String phone;
	private int levelid;
	
	private int areaid;
	private String company;
	
	public Distributor() {
		super();
	}
	public Distributor(int id, String identity, String password, String name, String address, String information,
			String phone,int levelid,int areaid,String company) {
		super();
		this.id = id;
		this.identity = identity;
		this.password = password;
		this.name = name;
		this.address = address;
		this.information = information;
		this.phone=phone;
		this.levelid = levelid;
		this.areaid=areaid;
		this.company=company;
	}
	
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public int getLevelid() {
		return levelid;
	}
	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}
	
	
}
