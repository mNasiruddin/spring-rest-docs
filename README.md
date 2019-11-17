# Student API Docs
Demonstrates Spring Rest Docs versus Swagger

# What is this project?
- API docs for each service, is business critical. Without proper API docs, integration becomes tough. 

# But we already have swagger?
- yes, swagger works but not a quality api docs

# Why do I say that?
- [Presentation - mac keynote](src/docs/presentation/swaggerVsSpringRestDocs.key)
- [Presentation - ppt](src/docs/presentation/swaggerVsSpringRestDocs.ppt)

# How does this work?

## Input
- Step 1 :  set up
  - Set up project using [Spring Initializr](https://start.spring.io/)
  - Include all spring rest docs related dependencies which can be found here for [maven](pom.xml) or [gradle](build.gradle)
- Step 2 : build api
  - build CRUD endpoints to api
  - to produce fully automated content of api, spring auto rest docs uses javadocs, java constraints
  - ex : [StudentRequest](src/main/java/com/example/docs/student/domain/StudentRequest.java), Here @ApiModelProperty, @ApiModel is part of swagger only
- Step 3 : api doc base file
  - To produce api doc, spring rest docs uses [asciidoc](https://asciidoctor.org/docs/asciidoc-syntax-quick-reference/)
  - we need to hand write base file like [index.adoc](src/docs/asciidoc/index.adoc)
  - index file should have all test produce .adoc files
  - gradle task [asciidoctor](build.gradle) or maven plugin [asciidoctor-maven-plugin](pom.xml) will convert asciidoc to html, pdf etc...
- Step 4 : write integration test
  - write integration tests as you normally would write, no changes at all ex : [StudentIntegrationTest.java](src/test/java/com/example/docs/integration/student/StudentIntegrationTest.java)
  - to produce api docs from the integration test, extend [ApiDocBase.java](src/test/java/com/example/docs/integration/ApiDocBase.java)
- Step 5 : run task
  - via [maven](#via-maven) or [gradle](#via-gradle)

## Output
[Here is API docs](static/api/docs/index.html)

# Producing api docs

make sure java 8 is set jdk in IDE

# via maven

- mvn clean
- mvn install

# via gradle

- gradle clean
- gradle build

## hurray api docs are [here](static/api/docs/index.html)

After application is started, API docs can be accessed at [endpoint](http://localhost:8085/api/docs/index.html)
