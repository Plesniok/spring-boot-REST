package com.architecture.springbootrest.database;

import com.architecture.springbootrest.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmployeesRepository extends CrudRepository<Employee, Long> {

    List<Employee> findById(int userId);

}
