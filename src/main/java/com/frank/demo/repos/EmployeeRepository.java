package com.frank.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.frank.demo.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
