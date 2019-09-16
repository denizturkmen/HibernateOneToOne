package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Adress;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
		//getEmployeeAndAddressbyEmployeeId();
		getEmployeeAndAddressbyAddressId();
	}


	private static void getEmployeeAndAddressbyAddressId() {
		
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	Adress address = session.get(Adress.class, 3);
	    	System.out.println(address);
	    	System.out.println(address.getEmployee());
	    	
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	private static void getEmployeeAndAddressbyEmployeeId() {
		Employee employee = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	employee = session.get(Employee.class, 1);
	    	System.out.println(employee);
	    	Adress address = employee.getAdress();
	    	System.out.println(address);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
