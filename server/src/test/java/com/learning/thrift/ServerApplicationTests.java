package com.learning.thrift;

import com.facebook.nifty.client.HttpClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.learning.thrift.service.CalculationService;
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
public class ServerApplicationTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	CalculationService clientCalcualtionService;

	@Before
	public void setUp() throws Exception {
		ThriftClientManager clientManager = new ThriftClientManager();
		URI uri = URI.create("http://localhost:8080/calculate");
		HttpClientConnector connector = new HttpClientConnector(uri);
		this.clientCalcualtionService = clientManager.createClient(connector, CalculationService.class).get();
	}

	@Test
	public void contextLoads() {
		Random random = new Random();
		int one = Math.abs(random.nextInt());
		int two =  Math.abs(random.nextInt());
		LOG.info("Adding {} and {}, Answer is {}", one, two, clientCalcualtionService.add(one,two));
	}
}
