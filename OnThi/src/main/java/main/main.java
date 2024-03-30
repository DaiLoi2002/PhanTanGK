package main;

import com.mongodb.reactivestreams.client.MongoDatabase;

import dao.CustomerDAO;
import utils.ConnectDB;

public class main {
	public static void main(String[] args) {
		ConnectDB conn = new ConnectDB();
		MongoDatabase db = conn.getDataBDatabase();
		
		CustomerDAO customerDao = new CustomerDAO(db);
		System.out.println(customerDao.getCustomersByUserNameAndPackage("johndoe85", "premium"));
		System.out.println(customerDao.getCustomersByTransitionsAndMaxValue());
		System.out.println(customerDao.updateStreetByUserName("johndoe85", "DaiLoi	"));
	}
}
