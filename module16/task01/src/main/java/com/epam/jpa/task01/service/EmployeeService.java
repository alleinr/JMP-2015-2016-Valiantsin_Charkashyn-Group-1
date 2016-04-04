package com.epam.jpa.task01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task01.dao.EmployeeDAO;
import com.epam.jpa.task01.model.Employee;

@Component("employeeService")
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	public Employee create(Employee account) {
		account = dao.create(account);
		return account;
	}

	public void delete(Employee account) {
		if (account != null) {
			dao.delete(account.getId());
		}

	}

	public Employee getEmployee(String id) {
		Employee account = null;
		account = dao.get(id);
		return account;

	}

	public List<Employee> getAll() {
		List<Employee> accountList = null;
		accountList = dao.getAll();
		return accountList;
	}

}
