package com.chandra.SpringBoot_Thyemleaf_H2_JPA_REST.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.SpringBoot_Thyemleaf_H2_JPA_REST.model.EmployeeEntity;
import com.chandra.SpringBoot_Thyemleaf_H2_JPA_REST.repository.EmployeeRepostory;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepostory employeeRepository;

	// create a employee

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
		if (entity.getId() == null) {
			entity = employeeRepository.save(entity);
			return entity;
		} else {
			Optional<EmployeeEntity> employee = employeeRepository.findById(entity.getId());
			if (employee.isPresent()) {
				EmployeeEntity newEntity = new EmployeeEntity();
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity.setEmail(entity.getEmail());
				newEntity = employeeRepository.save(newEntity);
				return newEntity;
			} else {
				entity = employeeRepository.save(entity);
				return entity;
			}
		}
	}
	// get all employees

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> result = (List<EmployeeEntity>) employeeRepository.findAll();
		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	// get Employee based on id
	public EmployeeEntity getEmployeeById(Long id) throws Exception {
		Optional<EmployeeEntity> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new Exception("No Employee Record exist for given id");
		}
	}

	// delete Employee
	public void deleteEmployeeById(Long id) throws Exception {
		Optional<EmployeeEntity> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new Exception("No Employee Record exist for given id");
		}
	}

}
