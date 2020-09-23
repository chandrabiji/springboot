package com.chandra.SpringBoot_Thyemleaf_H2_JPA_REST.repository;

import org.springframework.data.repository.CrudRepository;

import com.chandra.SpringBoot_Thyemleaf_H2_JPA_REST.model.EmployeeEntity;

public interface EmployeeRepostory extends CrudRepository<EmployeeEntity, Long> {

}
