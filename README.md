# Swift-Thrift Demo

Maven and Spring based demo project, representing Thrift-Swift working demo.

It contains two modules, Client and Server.

**Server**
It register servlet with endpoint to desired port. To generate thrift files (From swift class file) use following command
```$xslt
mvn process-classes exec:java
```

**Client**
It calls server servlet with respective endpoint. To generate Swift Files (Java Files) from existing thrift files, use following command
```$xslt
mvn generate-sources
```

To run server and client, use following command
```$xslt
mvn spring-boot:run
```

First Run Server, then client to see result.
