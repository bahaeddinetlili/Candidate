FROM openjdk:17
EXPOSE  8077
ADD target/candidate-0.0.1-SNAPSHOT.jar candidate-0.0.1.jar
ENTRYPOINT ["java" ,"-jar" ,"candidate-0.0.1.jar"]