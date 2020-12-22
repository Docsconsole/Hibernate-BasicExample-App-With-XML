package com.docsconsole.tutorials.client;
import java.util.List;

import com.docsconsole.tutorials.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateMainClient {

	
	/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/docsconsole";

	static final String USERNAME = "root";
	static final String PASSWORD = "";*/

	public static void main(String[] args) {
		
		System.out.println("::::::::::::::::--------------------Started main method here-------------------::::::::::::::::");

		SessionFactory sfactory = HibernateUtil.getSessionFactory();
		System.out.println("::::::::::::::::--------------------SessionFactory is created here-------------------::::::::::::::::");
		Session session = sfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println("::::::::::::::::--------------------Transaction is created here-------------------::::::::::::::::");
		Query query = session.createSQLQuery("select emp_id, emp_first_name, emp_last_name FROM employee");
		List resultList = query.list();
		
		for(Object object: resultList){
			Object[] objectArray =(Object[])object;
			System.out.println("::::::::::::::::--------------------Employe Id:"+objectArray[0]);
			System.out.println("::::::::::::::::--------------------Employe First Name:"+objectArray[1]);
			System.out.println("::::::::::::::::--------------------Employe Last Name:"+objectArray[2]);
		}
		tx.commit();
		
	}
}