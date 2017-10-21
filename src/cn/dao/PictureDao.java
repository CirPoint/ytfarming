package cn.dao;

import java.util.List;

import cn.bean.Picture;

public interface PictureDao {
	//根据商品id查找图片
	public List<Picture> findPicByGoodsid(int goodsid);
	//上传图片
	public boolean UpdatePic(Picture picture);
	//删除图片
	public boolean DeletPic(int id);
}
