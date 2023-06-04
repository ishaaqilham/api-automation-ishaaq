# API Automation

## Introduction

* This project is a Maven-Java project created for API automation
* This repo uses RestAssured as the main tool for API automation
* This project could be founded in: https://github.com/ishaaqilham/api-automation-ishaaq

## Getting started
###### Please install below software in your machine to successfully run the tests in this project
* Java 1.8/ 32-Bit
* Maven - Version 3.6.x
* IntelliJ - Latest version
* Install Git and configure ssh keys
###### Clone the project to your local using the below command
```bash
   git clone git@github.com:ishaaqilham/api-automation-ishaaq.git
   ```

## Build the project
* Below command could be used to build the project:
  ```bash
  mvn clean install -DskipTests=true
  ```

## Test suites
* Command to execute the categories details API test suite
  ```bash
  mvn clean test -Dsuite=categories_details
  ```