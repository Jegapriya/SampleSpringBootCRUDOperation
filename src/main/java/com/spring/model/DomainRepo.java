package com.spring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DomainRepo")
public interface DomainRepo extends JpaRepository<Domain, Long> {

}