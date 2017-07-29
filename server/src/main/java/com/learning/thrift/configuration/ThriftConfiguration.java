package com.learning.thrift.configuration;

import com.facebook.nifty.processor.NiftyProcessorAdapters;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.learning.thrift.service.AdditionService;
import com.learning.thrift.service.SubtractionService;
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
  public ServletRegistrationBean additionServlet(ThriftCodecManager thriftCodecManager,
      TProtocolFactory protocolFactory,
      AdditionService additionService) {
    ThriftServiceProcessor processor =
        new ThriftServiceProcessor(thriftCodecManager, Arrays.asList(),
            additionService);

    TServlet tServlet = new TServlet(
        NiftyProcessorAdapters.processorToTProcessor(processor), protocolFactory,
        protocolFactory);

    final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(tServlet,
        "/add");

    servletRegistrationBean.setName("additionServlet");
    return servletRegistrationBean;
  }

  @Bean
  public ServletRegistrationBean subtractionServlet(ThriftCodecManager thriftCodecManager,
      TProtocolFactory protocolFactory,
      SubtractionService subtractionService) {
    ThriftServiceProcessor processor =
        new ThriftServiceProcessor(thriftCodecManager, Arrays.asList(),
            subtractionService);

    TServlet tServlet = new TServlet(
        NiftyProcessorAdapters.processorToTProcessor(processor), protocolFactory,
        protocolFactory);

    final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(tServlet,
        "/subtract");

    servletRegistrationBean.setName("subtractionServlet");
    return servletRegistrationBean;
  }
}
