package cn.help;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Help
{
	
	public static long getTime() //获得现在的时间（时间戳）
	 {
	    Date date = new Date();
	    long times = date.getTime();
	    return times;
	 }
	 public static long dateToStamp(String s)  //把标准格式的时间转换成时间戳
	 {
		   long timeStamp=0;
		   try
		   	{
			    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
			    Date date = simpleDateFormat.parse(s);
			    timeStamp = date.getTime();
		   	}
		   catch (Exception e)
		   	{
			// TODO: handle exception
		   	}
		   return timeStamp;
	 }
	 
	 public static long dayToStamp(String s)  //把当天日期转换成时间戳
	 {
		   long timeStamp=0;
		   try
		   	{
			    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    Date date = simpleDateFormat.parse(s);
			    timeStamp = date.getTime();
		   	}
		   catch (Exception e)
		   	{
		   	}
		   return timeStamp;
	 }
	
	 public static String StampTodate(long l) //把时间戳转换成标准时间
	 {
		 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		 String d=format.format(l);
		 return d;
	 }
	 
	 public static String StampToday(long l) //把时间戳转换成当天日期
	 {
		 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		 String d=format.format(l);
		 return d;
	 }
	
	//乱码处理
	 public static String txt(String t){
		 String rec=t;
		 String rec1="";
		 try {
			rec1=new String(rec.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rec1;
		 
	 }
}
