package cn.bean;

public class Log {
	private int id;
	private String time;
	private String record;
	private String operator;
	private String ip;
	
	
	public Log() {
		super();
	}
	public Log(int id, String time, String record, String operator, String ip) {
		super();
		this.id = id;
		this.time = time;
		this.record = record;
		this.operator = operator;
		this.ip = ip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
