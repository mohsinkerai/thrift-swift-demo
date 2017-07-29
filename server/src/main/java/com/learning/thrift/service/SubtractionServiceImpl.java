package com.learning.thrift.service;

import org.springframework.stereotype.Component;

@Component
public class SubtractionServiceImpl implements SubtractionService {

  @Override
  public int subtract(int a, int b) {
    return a-b;
  }
}
