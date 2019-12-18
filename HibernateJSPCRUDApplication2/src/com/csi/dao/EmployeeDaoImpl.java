package com.csi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.csi.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static SessionFactory Factory;
	@Override
	public List<Employee> showEmployees() {
		// TODO Auto-generated method stub
		Factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session Session= Factory.openSession();
		List<Employee>employeelist= Session.createQuery("from Employee").list();
		return employeelist;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		Factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session Session= Factory.openSession();
		Transaction transaction=Session.beginTransaction();
		Session.save(employee);
		transaction.commit();
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(int empId, String empName, double empSalary) {
		Factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session Session= Factory.openSession();
		Transaction transaction=Session.beginTransaction();
		List<Employee>employeelist= Session.createQuery("from Employee").list();
		for(Employee emp:employeelist)
		{
			if(emp.getEmpId()==empId)
			{
				emp.setEmpName(empName);
				emp.setEmpSalary(empSalary);
				Session.save(emp);
				transaction.commit();
				
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session Session= Factory.openSession();
		Transaction transaction=Session.beginTransaction();
		Session.delete(employee);
		transaction.commit();
		
		
		// TODO Auto-generated method stub
		
	}

}
