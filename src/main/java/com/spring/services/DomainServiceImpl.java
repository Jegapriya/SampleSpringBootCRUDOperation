package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Domain;
import com.spring.model.DomainRepo;

@Service("DomainService")
public class DomainServiceImpl implements DomainService {

	@Autowired
	private DomainRepo domainRepository;

	@Override
	public List<Domain> getAllDomain() {
		// TODO Auto-generated method stub
		return domainRepository.findAll();
	}

	@Override
	public Domain getDomainById(long id) {
		return domainRepository.findOne(id);
	}

	@Override
	public Domain saveDomain(Domain todo) {
		return domainRepository.save(todo);
	}

	@Override
	public void removeDomain(Domain todo) {
		domainRepository.delete(todo);
	}

}