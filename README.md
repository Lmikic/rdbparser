# rdbparser
use java to parse rdbfile serialized by proto
### 1. The sample project operate redis by spring-boot-starter-data-redis instead of Jedis
### 2. The version of redis cluster is 5.0.5; the version of proto is 3.10.0
### 3. The sample proto file is idmapping.proto
### 4. Use com.sogo.rdbparser.ReadWriteRedisMainApplication to write/read redis
#### 4.1 uncomment "//@SpringBootApplication" in ReadWriteRedisMainApplication.java
####  4.2 comment "@SpringBootApplication" in RdbFileParserMainApplication.java
### 5. Use com.sogo.rdbparser.RdbFileParserMainApplication to parse rdb file serialized by protocol buffer
####  5.1 uncomment "//@SpringBootApplication" in RdbFileParserMainApplication.java
####  5.5 comment "@SpringBootApplication" in ReadWriteRedisMainApplication.java
### 6. The name of rdb file is "8001.rdb"
### 7. stack trace
```
com.google.protobuf.InvalidProtocolBufferException: Protocol message end-group tag did not match expected tag.
        at com.google.protobuf.InvalidProtocolBufferException.invalidEndTag(InvalidProtocolBufferException.java:106)
        at com.google.protobuf.CodedInputStream$ArrayDecoder.checkLastTagWas(CodedInputStream.java:635)
        at com.google.protobuf.AbstractParser.parsePartialFrom(AbstractParser.java:160)
        at com.google.protobuf.AbstractParser.parseFrom(AbstractParser.java:191)
        at com.google.protobuf.AbstractParser.parseFrom(AbstractParser.java:203)
        at com.google.protobuf.AbstractParser.parseFrom(AbstractParser.java:208)
        at com.google.protobuf.AbstractParser.parseFrom(AbstractParser.java:48)
        at com.sogo.rdbparser.proto.IdMappingProto$IdBrief.parseFrom(IdMappingProto.java:446)
        at com.sogo.rdbparser.RdbFileParserMainApplication.parseIdMappingRdbFile(RdbFileParserMainApplication.java:121)
        at com.sogo.rdbparser.RdbFileParserMainApplication.run(RdbFileParserMainApplication.java:42)
        at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:784)
        at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:768)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:322)
        at com.sogo.rdbparser.RdbFileParserMainApplication.main(RdbFileParserMainApplication.java:28)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:48)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:87)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:51)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:52)
```
