package com.spring.services;

import java.util.List;

import com.spring.model.Domain;

public interface DomainService {
	public List<Domain> getAllDomain();

	public Domain getDomainById(long id);

	public Domain saveDomain(Domain todo);

	public void removeDomain(Domain todo);
}