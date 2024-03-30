package entity;

import java.util.Date;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Customers {

	private ObjectId id;
	private String title;
	private String first;
	private String last;
	private String email;
	private String dob;
	private String user_name;
	private String package_;
	private String prio_support;
	private String registered_on;
	private int transactions;
	private Address address;
	private List<Payment> payments;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPackage_() {
		return package_;
	}
	public void setPackage_(String package_) {
		this.package_ = package_;
	}
	public String getPrio_support() {
		return prio_support;
	}
	public void setPrio_support(String prio_support) {
		this.prio_support = prio_support;
	}
	public String getRegistered_on() {
		return registered_on;
	}
	public void setRegistered_on(String registered_on) {
		this.registered_on = registered_on;
	}
	public int getTransactions() {
		return transactions;
	}
	public void setTransactions(int transactions) {
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", title=" + title + ", first=" + first + ", last=" + last + ", email=" + email
				+ ", dob=" + dob + ", user_name=" + user_name + ", package_=" + package_ + ", prio_support="
				+ prio_support + ", registered_on=" + registered_on + ", transactions=" + transactions + ", address="
				+ address + ", payments=" + payments + "]";
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Customers(ObjectId id, String title, String first, String last, String email, String dob, String user_name,
			String package_, String prio_support, String registered_on, int transactions, Address address,
			List<Payment> payments) {
		super();
		this.id = id;
		this.title = title;
		this.first = first;
		this.last = last;
		this.email = email;
		this.dob = dob;
		this.user_name = user_name;
		this.package_ = package_;
		this.prio_support = prio_support;
		this.registered_on = registered_on;
		this.transactions = transactions;
		this.address = address;
		this.payments = payments;
	}
	
	
	
}
