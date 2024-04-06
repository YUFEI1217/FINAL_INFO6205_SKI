package edu.neu.dataStore;

public class rateData {
	
	String name, time, resort, content;
	double rate;
	
	public rateData() {
		
	}
	
	public rateData(String username, String time, String resort, double rate, String content) {
		this.name = username;
		this.time = time;
		this.resort = resort;
		this.rate = rate;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResort() {
		return resort;
	}

	public void setResort(String resort) {
		this.resort = resort;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
