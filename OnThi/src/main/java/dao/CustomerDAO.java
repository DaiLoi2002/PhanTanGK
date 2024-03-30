package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.bson.Document;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import entity.Customers;
import entity.Payment;

public class CustomerDAO {
	private MongoCollection<Customers> collection;

	public CustomerDAO(MongoDatabase db) {
		// TODO Auto-generated constructor stub
		collection = db.getCollection("customers", Customers.class);
	}

	public List<Customers> getCustomersByUserNameAndPackage(String username, String package_) {
		List<Customers> customers = new ArrayList<Customers>();
		CountDownLatch latch = new CountDownLatch(1);
		Document query = new Document("user_name", username).append("package_", package_);
		FindPublisher<Customers> publicer = collection.find(query);
		Subscriber<Customers> subscriber = new Subscriber<Customers>() {
			private Subscription s;

			@Override
			public void onSubscribe(Subscription s) {
				// TODO Auto-generated method stub
				this.s = s;
				s.request(1);

			}

			@Override
			public void onNext(Customers t) {
				// TODO Auto-generated method stub
				customers.add(t);
				this.s.request(1);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();

			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				latch.countDown();
			}
		};
		publicer.subscribe(subscriber);
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	public List<Customers> getCustomersByTransitionsAndMaxValue() {
		List<Customers> customers = new ArrayList<Customers>();
		CountDownLatch latch = new CountDownLatch(1);
		Document query = new Document("transactions", new Document("$gte", 50).append("$lte", 55));
		FindPublisher<Customers> publicer = collection.find(query);
		Subscriber<Customers> subscriber = new Subscriber<Customers>() {
			private Subscription s;

			@Override
			public void onSubscribe(Subscription s) {
				// TODO Auto-generated method stub
				this.s = s;
				s.request(1);

			}

			@Override
			public void onNext(Customers t) {
				// TODO Auto-generated method stub
				customers.add(t);
				this.s.request(1);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();

			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				latch.countDown();
			}
		};
		publicer.subscribe(subscriber);
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customers.forEach(customer -> {
			Payment maxPayment = null;
			for (Payment payment : customer.getPayments()) {
				if (maxPayment == null || payment.getValue() > maxPayment.getValue()) {
					maxPayment = payment;
				}
			}
			if (maxPayment != null) {
				List<Payment> paymentList = new ArrayList<>();
				paymentList.add(maxPayment);
				customer.setPayments(paymentList);
			}
		});
		return customers;
	}

	public boolean updateStreetByUserName(String userName, String street) {
		List<Customers> customers = new ArrayList<Customers>();
		CountDownLatch latch = new CountDownLatch(1);
		Document query = new Document("user_name", userName);
		Document updateDoc = new Document("$set", new Document("address.street.name", street));
		Publisher<UpdateResult> publicer = collection.updateOne(query, updateDoc);
		Subscriber<UpdateResult> subscriber = new Subscriber<UpdateResult>() {
			private Subscription s;

			@Override
			public void onSubscribe(Subscription s) {
				// TODO Auto-generated method stub
				this.s=s;
				s.request(1);
				
			}

			@Override
			public void onNext(UpdateResult t) {
				// TODO Auto-generated method stub
				this.s.request(1);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				latch.countDown();
			}			
		};
		publicer.subscribe(subscriber);
		try {
			latch.await();
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
