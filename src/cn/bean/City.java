package cn.bean;

public class City {
	private int id;
	private String name;
	private int proid;
	
	public City() {
		super();
	}
	public City(int id, String name, int proid) {
		super();
		this.id = id;
		this.name = name;
		this.proid = proid;
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
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	
}
