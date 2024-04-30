# CiraConnect Automation

UI Test Automation Project.

## Built With

* [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.


* [JDK-8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit


* [Git](https://git-scm.com/) - Free and Open-Source distributed version control system


* [TestNG](https://testng.org/) - TestNG is designed to cover all categories of tests: unit, functional, end-to-end, integration, etc.


* [Log4j](https://logging.apache.org/log4j/1.2/) - log4j is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License.


* [Extent Reports](https://testng.org/) - Extent Report is a library that can be used to build a customized detailed report.


## Features : 

 [+] Environments specific execution
 
 [+] Test execution logs in HTML format. 

 
## To-Do

[ - ] BrowserStack support
 
## Issues

* Currently no issues.

## Running the application locally

There are several ways to run a maven application on your local machine.

- Download the zip or clone the Git repository.

- Unzip the zip file (if you downloaded one)

- Open Command Prompt and Change directory (cd) to folder containing pom.xml

- 'env_name' i.e Environments are - *local*, *dev*, *qa*, *stage*, *prod*

```shell
mvn clean test -Denv=<env_name>

```
- to parametrize multiple test groups like Smoke , Functional, Regression

```shell
mvn clean test -Denv=<env_name> -Dgroups=<TestGroups>
```
Example : 

```shell
mvn clean test -Denv=qa -Dgroups=Smoke,Regression

```
