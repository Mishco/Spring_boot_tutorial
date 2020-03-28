# Spring boot tutorial

[![MIT license](https://img.shields.io/badge/license-MIT-green.svg)](#)
[![Build Status](https://travis-ci.org/Mishco/Spring_boot_tutorial.svg?branch=master)](https://travis-ci.org/Mishco/Spring_boot_tutorial)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=sk.mishco%3Aspring-boot-tutorial&metric=alert_status)](https://sonarcloud.io/dashboard/index/sk.mishco:spring-boot-tutorial)

[![SonarCloud Coverage](https://sonarcloud.io/api/project_badges/measure?project=sk.mishco%3Aspring-boot-tutorial&metric=coverage)](https://sonarcloud.io/component_measures/metric/coverage/list?id=sk.mishco%3Aspring-boot-tutorial)
[![SonarCloud Bugs](https://sonarcloud.io/api/project_badges/measure?project=sk.mishco%3Aspring-boot-tutorial&metric=bugs)](https://sonarcloud.io/component_measures/metric/reliability_rating/list?id=sk.mishco%3Aspring-boot-tutorial)
[![SonarCloud Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=sk.mishco%3Aspring-boot-tutorial&metric=vulnerabilities)](https://sonarcloud.io/component_measures/metric/security_rating/list?id=sk.mishco%3Aspring-boot-tutorial)

## Technology stack

* Spring version 2.2.6.RELEASE
* [Java 14](https://adoptopenjdk.net/installation.html#)
* Maven
* Junit 5 

## Description

Simple code for latest Spring Boot and Java, plus integration and junit tests. 
Included Jacoco and SonarCloud for code quality.

## How to run it

Run the project

```bash
mvn clean package
mvn spring-boot:run
```

Run the tests

```bash
mvn clean test
```

## Run with Docker

1. First build the project with maven.
 
2. Build the docker image:

```bash
docker build -t springboottutorial .
```

or

```bash
docker build --build-arg JAR_FILE=target/*.jar -t springbootutorial . 
```

3. Run Docker container with specific port:

```bash
docker run -p 8080:8080 springbootutorial
``` 


