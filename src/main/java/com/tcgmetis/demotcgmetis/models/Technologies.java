package com.tcgmetis.demotcgmetis.models;

//import lombok.Data;

//@Data
public class Technologies {

    private String name;
    private  String yearsOfExperience;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
	@Override
	public String toString() {
		return "Technologies [name=" + name + ", yearsOfExperience=" + yearsOfExperience + "]";
	}
    
    

}