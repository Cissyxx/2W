package read1;

import java.util.Comparator;

public class building implements Comparator<building>, Comparable<building>{
	private String name;
	private String abbv;
	private String hour;
	private String location;
	private String contact;
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	void setAbbv(String abbv) {
		this.abbv = abbv;
	}
	
	String getAbbv() {
		return this.abbv;
	}
	
	void setHour(String hour) {
		this.hour = hour;
	}
	
	String getHour() {
		return this.hour;
	}
	
	void setLocation(String location) {
		this.location = location;
	}
	
	String getLocation() {
		return this.location;
	}
	
	void setContact(String contact) {
		this.contact = contact;
	}
	
	String getContact() {
		return this.contact;
	}

	@Override
	public int compareTo(building arg0) {
		// TODO Auto-generated method stub
		return this.name.compareToIgnoreCase(arg0.name);
	}

	@Override
	public int compare(building arg0, building arg1) {
		// TODO Auto-generated method stub
		return arg0.name.compareToIgnoreCase(arg1.name);
	}
	

}
