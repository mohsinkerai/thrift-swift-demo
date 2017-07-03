package com.learning.thrift.service;

import org.springframework.stereotype.Service;

/**
 * Created by Mohsin Mansoor Kerai on 03-Jul-17.
 */
@Service
public class CalculationServiceImpl implements CalculationService {

  @Override
  public int add(int a, int b) {
    return a+b;
  }
}
