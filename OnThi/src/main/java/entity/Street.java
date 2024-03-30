package entity;

public class Street {
	public Street() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String suffix;
	private String number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Street [name=" + name + ", suffix=" + suffix + ", number=" + number + "]";
	}
	public Street(String name, String suffix, String number) {
		super();
		this.name = name;
		this.suffix = suffix;
		this.number = number;
	}
	
}
