package com.tcgmetis.demotcgmetis.document;

import java.util.List;
//import lombok.Data;

import com.tcgmetis.demotcgmetis.models.Technologies;

//@Data
public class ProfileDocument {
	private String id;
    private String firstName;
    private String lastName;
    private List<Technologies> technologies;
    private List<String> emails;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Technologies> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<Technologies> technologies) {
		this.technologies = technologies;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	@Override
	public String toString() {
		return "ProfileDocument [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", technologies="
				+ technologies + ", emails=" + emails + "]";
	}
    
    
    
    
    
}
