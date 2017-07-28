namespace java.swift com.learning.thrift.files
namespace java com.learning.thrift.files



struct IntegerDTO {
  1:  i32 value;
  2:  i32 nullValue;
}

service CalculationService {
  i32 add(1:  i32 arg0, 2:  i32 arg1);
  i32 addObject(1:  IntegerDTO arg0, 2:  IntegerDTO arg1);
  IntegerDTO addObjectReturnObject(1:  IntegerDTO arg0, 2:  IntegerDTO arg1);
}
