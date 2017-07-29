package com.learning.thrift.service;

import com.learning.thrift.dto.IntegerDTO;
import org.springframework.stereotype.Service;

/**
 * Created by Mohsin Mansoor Kerai on 03-Jul-17.
 */
@Service
public class AdditionServiceImpl implements AdditionService {

  @Override
  public int add(int a, int b) {
    return a+b;
  }

  @Override
  public int addObject(IntegerDTO a, IntegerDTO b) {
    return a.getValue() + b.getValue();
  }

  @Override
  public IntegerDTO addObjectReturnObject(IntegerDTO a, IntegerDTO b) {
    IntegerDTO integerDTO = new IntegerDTO();
    integerDTO.setValue(a.getValue() + b.getValue());
    return integerDTO;
  }
}
