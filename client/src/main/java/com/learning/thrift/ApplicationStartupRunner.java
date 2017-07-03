package com.learning.thrift;

import com.learning.thrift.generated.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Mohsin Mansoor Kerai on 03-Jul-17.
 */
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

  Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Autowired
  CalculationService calculationService;

  @Override
  public void run(String... strings) throws Exception {
    LOG.info("Application Started");
    LOG.info("Adding 1 and 3 = {}", calculationService.add(1, 3));
  }
}
