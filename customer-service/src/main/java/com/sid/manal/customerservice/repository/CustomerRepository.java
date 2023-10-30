package com.sid.manal.customerservice.repository;

import com.sid.manal.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
