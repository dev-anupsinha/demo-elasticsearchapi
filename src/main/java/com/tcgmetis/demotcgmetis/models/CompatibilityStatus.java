package com.tcgmetis.demotcgmetis.models;

public class CompatibilityStatus {
	
	public int compStatusCode;
	public String compDesc;
	
	
	
	public CompatibilityStatus(int compStatusCode, String compDesc) {
		super();
		this.compStatusCode = compStatusCode;
		this.compDesc = compDesc;
	}
	
	public int getCompStatusCode() {
		return compStatusCode;
	}
	public void setCompStatusCode(int compStatusCode) {
		this.compStatusCode = compStatusCode;
	}
	public String getCompDesc() {
		return compDesc;
	}
	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	@Override
	public String toString() {
		return "CompatibilityStatus [compStatusCode=" + compStatusCode + ", compDesc=" + compDesc + "]";
	}
	
	
	

}
