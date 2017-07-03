package com.learning.thrift.service;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

/**
 * Created by Mohsin Mansoor Kerai on 03-Jul-17.
 */
@ThriftService("CalculationService")
public interface CalculationService {

  @ThriftMethod("add")
  int add(@ThriftField(1) int a,@ThriftField(2) int b);
}
