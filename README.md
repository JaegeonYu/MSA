## MSA Ecommerce Service

MSA 맛보기

## Getting started

### Setting Before

1. docker, docker compose
2. gradle
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


