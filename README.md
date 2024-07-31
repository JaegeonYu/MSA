## MSA Ecommerce Service

MSA 맛보기

## Getting started

### Setting Before
```bash
$ git clone https://github.com/JaegeonYu/MSA.git
```


### 1) Running Zookeeper & Kafka Broker using docker compose

```bash
$ docker-compose up -d
```

### 6) Running ConfigMap

```bash
$ kubectl apply -f ./k8s/configmap.yml
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