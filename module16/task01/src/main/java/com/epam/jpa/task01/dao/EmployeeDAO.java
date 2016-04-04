package com.epam.jpa.task01.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.epam.jpa.task01.model.Employee;

@Component
public class EmployeeDAO {
	public EntityManager em = Persistence.createEntityManagerFactory(
			"dbconnect").createEntityManager();

	public Employee create(Employee employee) {
		em.getTransaction().begin();
		employee = em.merge(employee);
		em.getTransaction().commit();
		return employee;
	}

	public void delete(String id) {
		em.getTransaction().begin();
		em.remove(get(id));
		em.getTransaction().commit();
	}

	public Employee get(String id) {
		return em.find(Employee.class, id);
	}

	public void update(Employee employee) {
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
	}

	public List<Employee> getAll() {
		TypedQuery<Employee> namedQuery = em.createNamedQuery("employee.getAll",
				Employee.class);
		return namedQuery.getResultList();
	}

}
