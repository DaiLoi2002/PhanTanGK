package entity;

import java.util.Date;

public class Payment {
	private String date;
	private double value;

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Payment [date=" + date + ", value=" + value + "]";
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Payment(String date, double value) {
		super();
		this.date = date;
		this.value = value;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
