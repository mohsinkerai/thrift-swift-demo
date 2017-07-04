package com.learning.thrift.service;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import com.learning.thrift.dto.IntegerDTO;

/**
 * Created by Mohsin Mansoor Kerai on 03-Jul-17.
 */
@ThriftService("CalculationService")
public interface CalculationService {

  @ThriftMethod("add")
  int add(@ThriftField(1) int a,@ThriftField(2) int b);

  @ThriftMethod("addObject")
  int addObject(@ThriftField(1) IntegerDTO a,@ThriftField(2) IntegerDTO b);

  @ThriftMethod("addObjectReturnObject")
  IntegerDTO addObjectReturnObject(@ThriftField(1) IntegerDTO a,@ThriftField(2) IntegerDTO b);
}
