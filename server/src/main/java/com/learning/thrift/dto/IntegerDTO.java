package com.learning.thrift.dto;

import com.facebook.swift.codec.ThriftConstructor;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

@ThriftStruct
public class IntegerDTO {

  int value;
  Integer nullValue;

  public IntegerDTO() {
  }

  @ThriftConstructor
  public IntegerDTO(int value, Integer nullValue) {
    this.value = value;
    this.nullValue = nullValue;
  }

  @ThriftField(1)
  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @ThriftField(2)
  public Integer getNullValue() {
    return nullValue;
  }

  public void setNullValue(Integer nullValue) {
    this.nullValue = nullValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    IntegerDTO that = (IntegerDTO) o;

    if (value != that.value) {
      return false;
    }
    return nullValue.equals(that.nullValue);
  }

  @Override
  public int hashCode() {
    int result = value;
    result = 31 * result + nullValue.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "IntegerDTO{" +
        "value=" + value +
        ", nullValue=" + nullValue +
        '}';
  }
}
