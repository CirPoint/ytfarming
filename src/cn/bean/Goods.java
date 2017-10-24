package cn.bean;

public class Goods {
	private int id;
	private String name;
	private String photo;
	private String description;
	private int tid;
	private int distributorid;
	private int city;
	private String time;
	
	
	public Goods() {
		super();
	}
	public Goods(int id, String name, String photo, String description, int tid, int distributorid,int city,String time) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.description = description;
		this.tid = tid;
		this.distributorid = distributorid;
		this.city= city;
		this.time=time;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getDistributorid() {
		return distributorid;
	}
	public void setDistributorid(int i) {
		this.distributorid = i;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
