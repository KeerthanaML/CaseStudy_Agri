package com.user.entity;

public class Address {
	    private String street;
	    private String pincode;
	    private String city;
	    private String state;
	    private String country;
	
	    
	    
		public Address(String street, String pincode, String city, String state, String country) {
			super();
			this.street = street;
			this.pincode = pincode;
			this.city = city;
			this.state = state;
			this.country = country;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
	    
	    
}
