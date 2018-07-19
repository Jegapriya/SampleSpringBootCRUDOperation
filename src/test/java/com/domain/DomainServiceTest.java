package com.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.model.Domain;
import com.spring.services.DomainServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class DomainServiceTest {

	@Mock
	private DomainServiceTest domainRepository;

	@InjectMocks
	private DomainServiceImpl domainService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllToDo() {
		List<Domain> domainList = new ArrayList<Domain>();
		domainList.add(new Domain(1, "Todo Sample 1", true));
		domainList.add(new Domain(2, "Todo Sample 2", true));
		domainList.add(new Domain(3, "Todo Sample 3", false));
		when(domainRepository.findAll()).thenReturn(domainList);

		List<Domain> result = domainService.getAllDomain();
		assertEquals(3, result.size());
	}

	@Test
	public void testGetToDoById() {
		Domain toDo = new Domain(1, "Todo Sample 1", true);
		when(domainRepository.findOne(1L)).thenReturn(toDo);
		Domain result = domainService.getDomainById(1);
		assertEquals(1, result.getId());
		assertEquals("Todo Sample 1", result.getText());
		assertEquals(true, result.isCompleted());
	}

	@Test
	public void saveToDo() {
		Domain domain = new Domain(8, "Todo Sample 8", true);
		when(domainRepository.save(domain)).thenReturn(domain);
		Domain result = domainRepository.saveToDo(domain);
		assertEquals(8, result.getId());
		assertEquals("Todo Sample 8", result.getText());
		assertEquals(true, result.isCompleted());
	}

	@Test
	public void removeToDo() {
		Domain domain = new Domain(8, "Todo Sample 8", true);
		domainService.removeDomain(domain);
		verify(domainRepository, times(1)).delete(domain);
	}

}