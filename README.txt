This exercise is built with the next tech stack:

TEST:

1.- Cucumber to make BDD (Behaviour Driven Development)  : http://cukes.info
2.- Mockito to support TDD:  http://code.google.com/p/mockito/

RUNTIME:

. Java 7
. Jersey
. Spring
. Spring Data
. JPA / Hibernate
. Embedded Jetty

Dev Support:

. Maven 3


In memory database : H2


To run the tests, in the command line , jut type: mvn clean integration-test -Pacceptance for acceptance test and mvn clean test for unit tests

To run them in Eclipse, just execute the class RunCukesTestIT as JUnit Test (it launch Cucumber) 


-> Test are separated : unit, integration and acceptance in different folders 
-> The server in launched by acceptance test

--> A 'fat' jar is created in the package phase with the maven plugin maven-shade-plugin. The idea is run the embedded server as: 

java -jar test.jar, instead being a war file

or you can run it this way: mvn exec:java 

