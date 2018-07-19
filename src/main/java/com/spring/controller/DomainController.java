package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.exception.DomainException;
import com.spring.model.Domain;
import com.spring.services.DomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DomainController {

	private static final Logger logger = LoggerFactory.getLogger(DomainController.class);

	@Autowired
	private DomainService domainService;

	@RequestMapping(value = "/domain", method = RequestMethod.GET)
	public ResponseEntity<List<Domain>> getAllToDo() {
		logger.info("Returning all the ToDo´s");
		return new ResponseEntity<List<Domain>>(domainService.getAllDomain(), HttpStatus.OK);
	}

	@RequestMapping(value = "/domain/{id}", method = RequestMethod.GET)
	public ResponseEntity<Domain> getDomainId(@PathVariable("id") long id) {
		logger.info("domain id to return " + id);
		Domain domainentity = domainService.getDomainById(id);
		if (domainentity == null || domainentity.getId() <= 0) {
			System.out.println("ToDo doesn´t exist");
		}
		return new ResponseEntity<Domain>(domainService.getDomainById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/domain/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeToDoById(@PathVariable("id") long id) {
		logger.info("ToDo id to remove " + id);
		Domain domainentity = domainService.getDomainById(id);
		if (domainentity == null || domainentity.getId() <= 0) {
			System.out.println("domain to delete doesn´t exist");
		}
		domainService.removeDomain(domainentity);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Domain has been deleted"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/domain", method = RequestMethod.POST)
	public ResponseEntity<Domain> saveToDo(@RequestBody Domain domaindow) {
		logger.info("Domain to save " + domaindow);
		return new ResponseEntity<Domain>(domainService.saveDomain(domaindow), HttpStatus.OK);
	}

	@RequestMapping(value = "/domain", method = RequestMethod.PATCH)
	public ResponseEntity<Domain> updateToDo(@RequestBody Domain domaindow) {
		logger.info("Domain to update " + domaindow);
		Domain domain = domainService.getDomainById(domaindow.getId());
		if (domaindow == null || domaindow.getId() <= 0) {

			System.out.println("ToDo to update doesn´t exist");
		}
		return new ResponseEntity<Domain>(domainService.saveDomain(domaindow), HttpStatus.OK);
	}

}