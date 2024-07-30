## MSA Ecommerce Service

MSA 맛보기

## Getting started

### Setting Before
```bash
$ git clone https://github.com/JaegeonYu/MSA.git
```

### 0) Create Docker network

```bash
$ docker network create --gateway 172.18.0.1 --subnet 172.18.0.0/16 ecommerce-network
```

### 1) Running Config-Service & RabbitMQ using docker compose

```bash
$ cd config-service
$ gradle build
$ docker-compose up -d
```

[cloud-config git repository](https://github.com/JaegeonYu/cloud-config)

### 2) Running Discovery-Service using docker compose

```bash
$ cd discovery-service
$ gradle build
$ docker-compose up -d
```

### 3) Running Apigateway-Service using docker compose

```bash
$ cd apigateway-service
$ gradle build
$ docker-compose up -d
```

### 4) Running Database using docker compose

```bash
$ cd dockerfiles/db
$ docker-compose up -d
```

### 5) Running Zookeeper & Single Kafka Broker using docker compose

```bash
$ cd dockerfiles/kafka-docker
$ docker-compose -f docker-compose-single-broker.yml up -d
```

### 6) Running Eureka Client Services

```bash
$ cd user-service
$ docker-compose up -d

$ cd order-service
$ docker-compose up -d

$ cd catalog-service
$ docker-compose up -d
```

## Blog Posting
1. [Eureka Server - Client](https://anythingis.tistory.com/186)
2. [Spring Cloud Gateway 사용 이유 & 설정](https://anythingis.tistory.com/187)
3. [Spring Cloud Cofing & Actuator](https://anythingis.tistory.com/191)
4. [Spring Cloud Bus Amqp & RabbitMQ](https://anythingis.tistory.com/192)
5. [Apache Kafka & Kafka Connect](https://anythingis.tistory.com/193)
6. [Insert Query Spring to Kafka로 위임](https://anythingis.tistory.com/195)
7. [CircuitBreaker](https://anythingis.tistory.com/196)

## Trouble Shooting
1. [JJWT 의존성, WeakKeyExcpetion](https://anythingis.tistory.com/190)
2. [Kafka Connect 설정에 맞지 않는 데이터로 인한 에러](https://anythingis.tistory.com/194)