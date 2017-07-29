package com.learning.thrift;

import static org.junit.Assert.assertEquals;

import com.facebook.nifty.client.HttpClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.learning.thrift.generated.AdditionService;
import com.learning.thrift.generated.IntegerDTO;
import java.net.URI;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TAdditionIntegrationTest {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	AdditionService additionService;

	@Before
	public void setUp() throws Exception {
		ThriftClientManager clientManager = new ThriftClientManager();
		URI uri = URI.create("http://localhost:8080/add");
		HttpClientConnector connector = new HttpClientConnector(uri);
		this.additionService = clientManager.createClient(connector, AdditionService.class).get();
	}

	@Test
	public void contextLoads() throws Exception{
		Random random = new Random();
		int one = Math.abs(random.nextInt());
		int two =  Math.abs(random.nextInt());
		LOG.info("Adding {} and {}, Answer is {}", one, two, additionService.add(one,two));
	}

	@Test
	public void contextLoadsWithObject() throws Exception{
		Random random = new Random();
		IntegerDTO a = new IntegerDTO();
		a.setValue(Math.abs(random.nextInt()));
		IntegerDTO b = new IntegerDTO();
		b.setValue(Math.abs(random.nextInt()));
		final int integerDTO = additionService.addObject(a, b);
		LOG.info("Adding {} and {}, Answer is {}", a, b, integerDTO);
		assertEquals(a.getValue()+b.getValue(),integerDTO);
	}

	@Test
	public void contextLoadsWithObjectReturnObject() throws Exception {
		Random random = new Random();
		IntegerDTO a = new IntegerDTO();
		a.setValue(Math.abs(random.nextInt()));
		IntegerDTO b = new IntegerDTO();
		b.setValue(Math.abs(random.nextInt()));
		final IntegerDTO integerDTO = additionService.addObjectReturnObject(a, b);
		LOG.info("Adding {} and {}, Answer is {}", a, b, integerDTO);
		assertEquals(a.getValue()+b.getValue(),integerDTO.getValue());
	}
}
