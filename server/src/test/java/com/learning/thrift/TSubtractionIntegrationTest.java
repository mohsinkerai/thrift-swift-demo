package com.learning.thrift;

import static org.junit.Assert.assertEquals;

import com.facebook.nifty.client.HttpClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.learning.thrift.generated.SubtractionService;
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
public class TSubtractionIntegrationTest {

  private Logger LOG = LoggerFactory.getLogger(this.getClass());

  private SubtractionService subtractionService;

  @Before
  public void setUp() throws Exception {
    ThriftClientManager clientManager = new ThriftClientManager();
    URI uri = URI.create("http://localhost:8080/subtract");
    HttpClientConnector connector = new HttpClientConnector(uri);
    this.subtractionService = clientManager.createClient(connector, SubtractionService.class).get();
  }

  @Test
  public void shouldSubtract() throws Exception {
    Random random = new Random();
    int one = Math.abs(random.nextInt());
    int two =  Math.abs(random.nextInt());
    final int result = subtractionService.subtract(one, two);
    assertEquals(result,one-two);
    LOG.info("Subtracting {}-{}, Answer is {}", one, two, result);
  }
}
