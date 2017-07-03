package com.learning.thrift.configuration;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mohsin Mansoor Kerai on 03-Jul-17.
 */
@Configuration
public class ThriftConfiguration {

  @Bean
  public TProtocolFactory tProtocolFactory() {
    return new TBinaryProtocol.Factory();
  }
}
