package task01;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {

	public static void main(String[] args) {

		Session session = HibernateSessionFactory.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		Cart cart = new Cart("total", "name");

		Item i1 = new Item("item-1");
		Item i2 = new Item("item-2");
		Item i3 = new Item("item-3");
		Item i4 = new Item("item-4");
		cart.setItems(new HashSet<>(Arrays.asList(i1, i2, i3, i4)));

		session.persist(cart);

		transaction.commit();
		session.close();
		
	}
}