package cn.help;


import cn.bean.Log;
import cn.dao.impl.LogDaoImpl;

public class UpLog {
	
	public static void Uplog(String details,String opretorname) {
		System.out.println("-----------生成日志----------");
		
		LogDaoImpl Logs=new LogDaoImpl();
		Log logs=new Log();	
		logs.setRecord(details);
		logs.setOperator(opretorname);
		if(logs.getOperator()!=null) {
			boolean t=Logs.UpdateLog(logs);
			if(t) {
					System.out.println("日志生成");
				}
			
		}
		
		else {
			System.out.println("失败");
		}
	}
}
