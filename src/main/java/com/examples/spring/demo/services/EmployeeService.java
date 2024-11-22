package com.examples.spring.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examples.spring.demo.model.Employee;
import com.examples.spring.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id)
				.orElse(null);
	}

	public Employee insertNewEmployee(Employee employee) {
		employee.setId(new Long(10));
		employee.setId(null);
		return employeeRepository.save(employee);
	}

	public Employee updateEmployeeById(long id, Employee replacement) {
		replacement.setId(null);
		replacement.setId(id);
		return employeeRepository.save(replacement);
	}

	public double calculateDiscount(int itemCount, double itemPrice) {
        if (itemCount < 0 || itemPrice < 0) {
            throw new IllegalArgumentException("Item count and price must be non-negative.");
        }

        double discount = 1;
        if (itemCount >= 10) {
            discount = 0.2; // 20% discount
        } else if (itemCount >= 5) {
            discount = 0.1; // 10% discount
        }

        return itemCount * itemPrice * (1 - discount);
    }
}
