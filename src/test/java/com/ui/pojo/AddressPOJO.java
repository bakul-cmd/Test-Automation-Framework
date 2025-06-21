package com.ui.pojo;

public class AddressPOJO {
	
	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postCode;
	private String homePh;
	private String mobileNo;
	private String otherinfo;
	private String addressAlias;
	private String state;
	
	
	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String postCode,
			String homePh, String mobileNo, String otherinfo, String addressAlias, String state) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.homePh = homePh;
		this.mobileNo = mobileNo;
		this.otherinfo = otherinfo;
		this.addressAlias = addressAlias;
		this.state = state;
	}
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", postCode=" + postCode + ", homePh=" + homePh + ", mobileNo=" + mobileNo
				+ ", otherinfo=" + otherinfo + ", addressAlias=" + addressAlias + ", state=" + state + "]";
	}
	public String getCompany() {
		return company;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomePh() {
		return homePh;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	public String getState() {
		return state;
	}
	
	
	

}
