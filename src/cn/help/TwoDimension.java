package cn.help;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.imageio.ImageIO;


import com.swetake.util.Qrcode;

public class TwoDimension {
	public static void QrcodeImg(String context,String imgPath) {
		//实例化一个Qrcode
		Qrcode qrcode =new Qrcode();
		//拍错率15%
		qrcode.setQrcodeErrorCorrect('M');
		//版本
		qrcode.setQrcodeVersion(7);
		//编码
		qrcode.setQrcodeEncodeMode('B');
		
		int width=140;
		int height=140;
		BufferedImage bufferImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		
		//绘制工具
		Graphics2D gs=bufferImage.createGraphics();
		//设置二维码背景色
		gs.setBackground(Color.white);
		//前景色
		gs.setColor(Color.BLACK);
		//定义二维码绘制区域
		gs.clearRect(0, 0, width, height);
		
		try {
			byte[] contentBytes=context.getBytes("UTF-8");
			boolean[][] codeOut=qrcode.calQrcode(contentBytes);
			for(int i=0;i<codeOut.length;i++) {
				for(int j=0;j<codeOut.length;j++) {
					if(codeOut[j][i]) {
						//那个位置为真，则涂为黑色
						gs.fillRect(j*3+2, i*3+2, 3, 3);
					}
				}
			}
			gs.dispose();
			File imgFile =new File(imgPath);
			try {
				//String uuidName=UUID.randomUUID().toString();
				ImageIO.write(bufferImage, "png", imgFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("二维码生成成功");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*public static void mian(String[] args) {
		System.out.println("二维码生成");
		QrcodeImg("weiyuan", "D:/WY/wy22.png");
	}*/
}
