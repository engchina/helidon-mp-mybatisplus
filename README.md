# Helidon Mybatis Plus Example

This example implements Helidon-MP and Mybatis Plus.

## Create Table

```
  CREATE TABLE "DEPT" 
   (	"DEPTNO" NUMBER(2,0), 
	"DNAME" VARCHAR2(14 BYTE), 
	"LOC" VARCHAR2(13 BYTE)
   ) ；

Insert into SYSTEM.DEPT (DEPTNO,DNAME,LOC) values (10,'ACCOUNTING','NEW YORK');
Insert into SYSTEM.DEPT (DEPTNO,DNAME,LOC) values (20,'RESEARCH','DALLAS');
Insert into SYSTEM.DEPT (DEPTNO,DNAME,LOC) values (30,'SALES','CHICAGO');
Insert into SYSTEM.DEPT (DEPTNO,DNAME,LOC) values (40,'OPERATIONS','BOSTON');

  CREATE TABLE "EMP" 
   (	"EMPNO" NUMBER(4,0), 
	"ENAME" VARCHAR2(10 BYTE), 
	"JOB" VARCHAR2(9 BYTE), 
	"MGR" NUMBER(4,0), 
	"HIREDATE" DATE, 
	"SAL" NUMBER(7,2), 
	"COMM" NUMBER(7,2), 
	"DEPTNO" NUMBER(2,0)
   ) ;

Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7839,'KING','PRESIDENT',null,to_date('81-11-17','RR-MM-DD'),5000,null,10);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7698,'BLAKE','MANAGER',7839,to_date('81-05-01','RR-MM-DD'),2850,null,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7782,'CLARK','MANAGER',7839,to_date('81-06-09','RR-MM-DD'),2450,null,10);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7566,'JONES','MANAGER',7839,to_date('81-04-02','RR-MM-DD'),2975,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7902,'FORD','ANALYST',7566,to_date('81-12-03','RR-MM-DD'),3000,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7369,'SMITH','CLERK',7902,to_date('80-12-17','RR-MM-DD'),800,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7499,'ALLEN','SALESMAN',7698,to_date('81-02-20','RR-MM-DD'),1600,300,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7521,'WARD','SALESMAN',7698,to_date('81-02-22','RR-MM-DD'),1250,500,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7654,'MARTIN','SALESMAN',7698,to_date('81-09-28','RR-MM-DD'),1250,1400,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7844,'TURNER','SALESMAN',7698,to_date('81-09-08','RR-MM-DD'),1500,0,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7876,'ADAMS','CLERK',7788,to_date('87-05-23','RR-MM-DD'),1100,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7900,'JAMES','CLERK',7698,to_date('81-12-03','RR-MM-DD'),950,null,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7934,'MILLER','CLERK',7782,to_date('82-01-23','RR-MM-DD'),1300,null,10);
```


## Modify ``microprofile-config.properties`` to correct url,user,password

```
vi src/main/resources/META-INF/microprofile-config.properties
```

## Build and run

With JDK8+
```bash
mvn package
java -jar target/helidon-mp-mybatisplus.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/
{"message":"Hello World!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greeting

curl -X GET http://localhost:8080/Jose
{"message":"Hola Jose!"}

curl -X GET http://localhost:8080/depts
[{"deptno":10,"dname":"ACCOUNTING","loc":"NEW YORK"},{"deptno":20,"dname":"RESEARCH","loc":"DALLAS"},{"deptno":30,"dname":"SALES","loc":"CHICAGO"},{"deptno":40,"dname":"OPERATIONS","loc":"BOSTON"}]

curl -X GET http://localhost:8080/emps
[{"deptno":10,"empno":7839,"ename":"KING","hiredate":"1981-11-16T16:00:00Z[UTC]","job":"PRESIDENT","sal":5000.0},{"deptno":30,"empno":7698,"ename":"BLAKE","hiredate":"1981-04-30T16:00:00Z[UTC]","job":"MANAGER","mgr":7839,"sal":2850.0},{"deptno":10,"empno":7782,"ename":"CLARK","hiredate":"1981-06-08T16:00:00Z[UTC]","job":"MANAGER","mgr":7839,"sal":2450.0},{"deptno":20,"empno":7566,"ename":"JONES","hiredate":"1981-04-01T16:00:00Z[UTC]","job":"MANAGER","mgr":7839,"sal":2975.0},{"deptno":20,"empno":7902,"ename":"FORD","hiredate":"1981-12-02T16:00:00Z[UTC]","job":"ANALYST","mgr":7566,"sal":3000.0},{"deptno":20,"empno":7369,"ename":"SMITH","hiredate":"1980-12-16T16:00:00Z[UTC]","job":"CLERK","mgr":7902,"sal":800.0},{"comm":300.0,"deptno":30,"empno":7499,"ename":"ALLEN","hiredate":"1981-02-19T16:00:00Z[UTC]","job":"SALESMAN","mgr":7698,"sal":1600.0},{"comm":500.0,"deptno":30,"empno":7521,"ename":"WARD","hiredate":"1981-02-21T16:00:00Z[UTC]","job":"SALESMAN","mgr":7698,"sal":1250.0},{"comm":1400.0,"deptno":30,"empno":7654,"ename":"MARTIN","hiredate":"1981-09-27T16:00:00Z[UTC]","job":"SALESMAN","mgr":7698,"sal":1250.0},{"comm":0.0,"deptno":30,"empno":7844,"ename":"TURNER","hiredate":"1981-09-07T16:00:00Z[UTC]","job":"SALESMAN","mgr":7698,"sal":1500.0},{"deptno":20,"empno":7876,"ename":"ADAMS","hiredate":"1987-05-22T15:00:00Z[UTC]","job":"CLERK","mgr":7788,"sal":1100.0},{"deptno":30,"empno":7900,"ename":"JAMES","hiredate":"1981-12-02T16:00:00Z[UTC]","job":"CLERK","mgr":7698,"sal":950.0},{"deptno":10,"empno":7934,"ename":"MILLER","hiredate":"1982-01-22T16:00:00Z[UTC]","job":"CLERK","mgr":7782,"sal":1300.0}]
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
