package claim;

public class Address {
	private String  streetNum, streetName,  city, state, zipCode;
	
	public Address(){}
	
	public Address(String streetName, String city, String state, String zipCode){
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public Address(String streetNum, String streetName, String city, String state, int zipCode){
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
	}
	public String toString(){
		return streetName+", "+city+", "+state+", "+ zipCode;
	}
	public String getStreetNum() {
		return streetNum;
	}
	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
