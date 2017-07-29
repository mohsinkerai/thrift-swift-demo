package com.learning.thrift.service;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

/**
 * Created by Mohsin Mansoor Kerai on 29-Jul-17.
 */
@ThriftService
public interface SubtractionService {

  @ThriftMethod
  int subtract(@ThriftField int a,@ThriftField int b);
}
