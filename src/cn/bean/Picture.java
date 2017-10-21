package cn.bean;

public class Picture {
	private int id;
	private String photo;
	private int goodsid;
	
	public Picture() {
		super();
	}
	public Picture(int id, String photo, int goodsid) {
		super();
		this.id = id;
		this.photo = photo;
		this.goodsid = goodsid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	
	
}
