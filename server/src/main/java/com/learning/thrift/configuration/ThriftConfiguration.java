package com.learning.thrift.configuration;

import com.facebook.nifty.processor.NiftyProcessorAdapters;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.learning.thrift.service.CalculationService;
import java.util.Arrays;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThriftConfiguration {

  @Bean
  public TProtocolFactory tProtocolFactory() {
    return new TBinaryProtocol.Factory();
  }

  @Bean
  public ThriftCodecManager thriftCodecManager() {
    return new ThriftCodecManager();
  }

  @Bean
  public ServletRegistrationBean thriftCalculationServelet(ThriftCodecManager thriftCodecManager,
      TProtocolFactory protocolFactory,
      CalculationService calculationService) {
    ThriftServiceProcessor processor =
        new ThriftServiceProcessor(thriftCodecManager, Arrays.<ThriftEventHandler>asList(),
            calculationService);

    TServlet tServlet = new TServlet(
        NiftyProcessorAdapters.processorToTProcessor(processor), protocolFactory,
        protocolFactory);

    return new ServletRegistrationBean(tServlet, "/calculate");
  }

}
