package entity;

public class Address {
	private String city;
	private String state;
	private String zipCode;
	private Street street;
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
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", street=" + street + "]";
	}
	public Address(String city, String state, String zipCode, Street street) {
		super();
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.street = street;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
