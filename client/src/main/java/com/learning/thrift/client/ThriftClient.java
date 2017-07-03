package com.learning.thrift.client;

import com.facebook.nifty.client.HttpClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.learning.thrift.generated.CalculationService;
import java.net.URI;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Mohsin Mansoor Kerai on 03-Jul-17.
 */
@Component
public class ThriftClient {

  @Bean
  public CalculationService supplyServiceThriftClient() throws Exception {
    ThriftClientManager clientManager = new ThriftClientManager();
    URI uri = URI.create("http://localhost:8080/calculate");
    HttpClientConnector connector = new HttpClientConnector(uri);
    return clientManager.createClient(connector, CalculationService.class).get();
  }
}
