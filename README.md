## MSA Ecommerce Service

MSA 맛보기

## Getting started

### 1) Setting Before

1. docker, docker compose
2. gradle

### 1) Running Config-Service & RabbitMQ using docker compose

```bash
$ cd config-service
$ gradle build
$ docker-compose up -d

```

[cloud-config git repository](https://github.com/JaegeonYu/cloud-config)

### 1) Running Discovery-Service using docker compose

```bash
$ cd discovery-service
$ gradle build
$ docker-compose up -d
```
