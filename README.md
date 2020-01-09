# Added
--------------------------------------------------------
--  DDL for Table T_USER
--------------------------------------------------------

  CREATE TABLE "T_USER" 
   (	"ID" VARCHAR2(50 BYTE), 
	"NAME" VARCHAR2(30 BYTE), 
	"AGE" NUMBER, 
	"EMAIL" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Index T_USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "T_USER_PK" ON "T_USER" ("ID") ;
  
--------------------------------------------------------
--  Constraints for Table T_USER
--------------------------------------------------------

  ALTER TABLE "T_USER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "T_USER" ADD CONSTRAINT "T_USER_PK" PRIMARY KEY ("ID");


--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "EMPLOYEE" 
   (	"EMPLOYEE_ID" VARCHAR2(20 BYTE), 
	"FIRST_NAME" VARCHAR2(20 BYTE), 
	"LAST_NAME" VARCHAR2(20 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Index EMPLOYEE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EMPLOYEE_PK" ON "EMPLOYEE" ("EMPLOYEE_ID") ;
  
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "EMPLOYEE" MODIFY ("EMPLOYEE_ID" NOT NULL ENABLE);
  ALTER TABLE "EMPLOYEE" ADD CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("EMPLOYEE_ID");



mvn install:install-file -Dfile=/path/to/ojdbc8.jar -DgroupId=com.oracle.jdbc -DartifactId=ojdbc8 -Dversion=18.3.0.0 -Dpackaging=jar

mvn install:install-file -Dfile=/path/to/oraclepki.jar -DgroupId=com.oracle.jdbc -DartifactId=oraclepki -Dversion=18.3.0.0 -Dpackaging=jar

mvn install:install-file -Dfile=/path/to/osdt_core.jar -DgroupId=com.oracle.jdbc -DartifactId=osdt_core -Dversion=18.3.0.0 -Dpackaging=jar

mvn install:install-file -Dfile=/path/to/osdt_cert.jar -DgroupId=com.oracle.jdbc -DartifactId=osdt_cert -Dversion=18.3.0.0 -Dpackaging=jar

<dependency>
    <groupId>com.oracle.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>18.3.0.0</version>
</dependency>
<dependency>
    <groupId>com.oracle.jdbc</groupId>
    <artifactId>oraclepki</artifactId>
    <version>18.3.0.0</version>
</dependency>
<dependency>
    <groupId>com.oracle.jdbc</groupId>
    <artifactId>osdt_core</artifactId>
    <version>18.3.0.0</version>
</dependency>
<dependency>
    <groupId>com.oracle.jdbc</groupId>
    <artifactId>osdt_cert</artifactId>
    <version>18.3.0.0</version>
</dependency>

# Helidon Quickstart MP Example

This example implements a simple Hello World REST service using MicroProfile.

## Build and run

With JDK8+
```bash
mvn package
java -jar target/helidon-mp-mybatisplus.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/greet
{"message":"Hello World!"}

curl -X GET http://localhost:8080/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting

curl -X GET http://localhost:8080/greet/Jose
{"message":"Hola Jose!"}
```

## Try health and metrics

```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...
. . .

# Prometheus Format
curl -s -X GET http://localhost:8080/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
{"base":...
. . .

```

## Build the Docker Image

```
docker build -t helidon-mp-mybatisplus .
```

## Start the application with Docker

```
docker run --rm -p 8080:8080 helidon-mp-mybatisplus:latest
```

Exercise the application as described above

## Deploy the application to Kubernetes

```
kubectl cluster-info                         # Verify which cluster
kubectl get pods                             # Verify connectivity to cluster
kubectl create -f app.yaml               # Deploy application
kubectl get service helidon-mp-mybatisplus  # Verify deployed service
```
