package cn.bean;

public class Manager {
	private int id;
	private String name;
	private String password;
	private String levelid;
	private String managerpwd;
	
	public Manager() {
		super();
	}
	public Manager(int id, String name, String password, String levelid,String managerpwd) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.levelid = levelid;
		this.managerpwd=managerpwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevelid() {
		return levelid;
	}
	public void setLevelid(String levelid) {
		this.levelid = levelid;
	}
	public String getManagerpwd() {
		return managerpwd;
	}
	public void setManagerpwd(String managerpwd) {
		this.managerpwd = managerpwd;
	}
	
	
	
}
