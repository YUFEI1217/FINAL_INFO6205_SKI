package edu.neu.UserRateMatch;

public class Resort {
	String name;
	String location;
	String introduction;
	String website;
	double avgRating;

	
	
	public Resort(String name, String location, String introduction, String website) {
		this.name = name;
		this.location = location;
		this.introduction = introduction;
		this.website = website;
	}
	
	
	
	public Resort(String name, String location, String introduction, String website, double avgRating) {
		this.name = name;
		this.location = location;
		this.introduction = introduction;
		this.website = website;
		this.avgRating =avgRating;
		
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public double getAvgRating() {
		return avgRating;
	}



	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	
	
	
	
	
}
 