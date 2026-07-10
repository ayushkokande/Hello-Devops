# Hello-Devops

A simple multi-module Maven project used to practice CI/CD pipelines. It builds a small Java library and packages a web application as a WAR that can be deployed to Tomcat, either directly or as a Docker image.

## Project structure

```
.
├── pom.xml                     # Parent POM (dependency & plugin management)
├── server/                     # Java library module (jar)
│   └── src/
│       ├── main/java/com/example/Greeter.java
│       └── test/java/com/example/TestGreeter.java
├── webapp/                     # Web application module (war)
│   └── src/main/webapp/
│       ├── index.jsp
│       └── WEB-INF/web.xml
├── Dockerfile                  # Packages the WAR into a Tomcat image
└── .github/workflows/main.yml  # GitHub Actions CI pipeline
```

- **server** — a minimal library with a `Greeter` class and its JUnit tests.
- **webapp** — a JSP web application packaged as `webapp.war`.

## Requirements

- JDK 17+
- Maven 3.6+
- Docker (optional, for containerized deployment)

## Build and test

```sh
mvn verify
```

This compiles both modules, runs the tests, and produces `webapp/target/webapp.war`.

Run only the tests:

```sh
mvn test
```

## Run with Docker

Build the WAR, then build and run the image:

```sh
mvn package
docker build -t hello-devops .
docker run -d -p 8080:8080 hello-devops
```

The app is then available at <http://localhost:8080/webapp/>.

## Deploy to an existing Tomcat

Copy `webapp/target/webapp.war` into Tomcat's `webapps/` directory and visit `http://<host>:8080/webapp/`.

## Continuous integration

GitHub Actions ([.github/workflows/main.yml](.github/workflows/main.yml)) runs on every push and pull request to `master`:

1. Sets up JDK 17 with a Maven dependency cache.
2. Runs `mvn -B verify` (build + tests).
3. Uploads `webapp.war` as a build artifact.
