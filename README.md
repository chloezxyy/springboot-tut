# springboot-tut

# What is Spring?
- Spring (framework) focuses on creating enterprise applications with java
- Offers IoC (Inversion of Control), transactions

# What is Springboot?
Spring boot is built ontop of Spring framework

# Spring Magic:
1. IoC - spring container decides the flow of the app, what objects are created
2. Dependency Injection - don't have to instantiate classes with the `new` keyword
3. Dependency Inversion 
4. Spring magic: Spring beans

## Beans?
A bean is simply an instance of the class that is managed by the `Spring Container`

# Spring IOC Container
- Part of the core of the Spring Framework
- Responsible for managing all the beans
- Performs dependency injection

Learnings:
- spring data jpa
- testing endpoint - generated-requests.http
- repository (db)
- dependency injection
- hibernate entity life cycle

To package and run the application:
- API -> .jar -> instance 1,2,...
- To run different instances: use maven to clean, then install. cd into /target folder and run this comd `java -jar demo-0.0.1-SNAPSHOT.jar --server.port=8081`

To create the project
- Go to spring initlizer: `https://start.spring.io/`

To install:
1. Install `psql` with homebrew or any package manager
2. Create a database
3. Add dependency in `pom.xml`
4. Add configs in `application.properties`
Eg.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

To run:
1. Run `DemoApplication` file - this will run the DemoApplication class, that is annotated with `@SpringBootApplication`, which is a collection of these 3 annotations: `@EnableAutoConfiguration`, `@Configuration`, and `@ComponentScan`
2. Spring detects classes annotated with `@RestController`/`@Controller` and registers them as Spring beans
3. Spring then maps request mappings defined in the Controller class `@GetMapping`/`@PostMapping`
4. Spring Boot starts embedded web server (Tomcat) and deploys the app, making the API endpoints available

- GET, POST, PUT, DELETE `/api/v1/student`

