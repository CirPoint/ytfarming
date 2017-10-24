package cn.bean;

public class Suggestion {
	private int id;
	private String content;
	private int distributorid;
	private int stateid;
	
	public Suggestion() {
		super();
	}
	public Suggestion(int id, String content, int distributorid, int stateid) {
		super();
		this.id = id;
		this.content = content;
		this.distributorid = distributorid;
		this.stateid = stateid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDistributorid() {
		return distributorid;
	}
	public void setDistributorid(int distributorid) {
		this.distributorid = distributorid;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	
	
}
