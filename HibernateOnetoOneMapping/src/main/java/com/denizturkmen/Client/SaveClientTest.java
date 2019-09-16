package com.denizturkmen.Client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Adress;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class SaveClientTest {

	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			session.beginTransaction();
			Employee employee = new Employee();
			employee.setEmployeeName("Deniz Türkmen");
			employee.setEmail("turkmen@hotmail.com");
			employee.setSalary(12345.0);
			employee.setDoj(new Date());
						
			Adress adress1 = new Adress();
			adress1.setCity("Ankara");
			adress1.setPin_code(78466545L);
			adress1.setState("Çukurambar");
			adress1.setStreet("Asd PArk");
	
			employee.setAdress(adress1);
			
			Employee employee1 = new Employee();
			employee1.setEmployeeName("Deniz Türkmens");
			employee1.setEmail("turkmesn@hotmail.com");
			employee1.setSalary(123452.0);
			employee1.setDoj(new Date());
			
			Adress adress2 = new Adress();
			adress2.setCity("istanbul");
			adress2.setPin_code(78466545L);
			adress2.setState("Üskudar");
			adress2.setStreet("Asd PArk");
			
			employee1.setAdress(adress2);
			
			session.persist(employee1);
			session.persist(employee);
			session.getTransaction().commit();
			
		}
		catch (HibernateException e) {
			
		}
		
		
	}
	
}
