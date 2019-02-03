# scala-docker

Base project to build lightweight docker images for Scala applications.

This project uses [Google's Jib Maven Plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin) which creates small best-pratice docker images for many languages.

Disclaimer:

The Jib plug-in is only available for [Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/) and offers no SBT version. As I am more familiar with Maven I chose this one.

Background on Jib

- [Introducing Jib — build Java Docker images better](https://cloudplatform.googleblog.com/2018/07/introducing-jib-build-java-docker-images-better.html)
- [Build containers faster with Jib, a Google image build tool for Java applications (YouTube)](https://www.youtube.com/watch?v=H6gR_Cv4yWI)

Based on: [akka/akka-http-quickstart-scala](https://github.com/akka/akka-http-quickstart-scala.g8)

## Configuration

As we are using Maven to build the Scala application the configuration is straight forward. The only mandatory item is `mainClass` as the plug-in will not be able to automatically find it for Scala code.

```xml
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>0.9.0</version>
    <configuration>
        <mainClass>com.example.QuickstartServer</mainClass>
    </configuration>
</plugin>
```

## Building a local docker image

```
mvn clean compile jib:dockerBuild
```

## Running Application in Docker

```
docker run -p 8080:8080 scala-maven:1.0.0-SNAPSHOT
```

Output:

```
Server online at http://0.0.0.0:8080/
```

## Testing the application

I am using [httpie](https://httpie.org/) for testing.

### Creating a new user

```
http POST http://127.0.0.1:8080/users name=Bill age:=50 countryOfResidence=France
```

```json
HTTP/1.1 201 Created
Content-Length: 36
Content-Type: application/json
Date: Sun, 03 Feb 2019 12:38:22 GMT
Server: akka-http/10.1.7

{
    "description": "User Bill created."
}
```

### Retrieving all users

```
http GET http://127.0.0.1:8080/users
```

```json
HTTP/1.1 200 OK
Content-Length: 66
Content-Type: application/json
Date: Sun, 03 Feb 2019 12:38:33 GMT
Server: akka-http/10.1.7

{
    "users": [
        {
            "age": 50,
            "countryOfResidence": "France",
            "name": "Bill"
        }
    ]
}
```
