mvn package
docker build -t jav .
docker run -p 8081:8080 jav