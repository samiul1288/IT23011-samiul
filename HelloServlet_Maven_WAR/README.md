# HelloWorld Servlet (Maven WAR)

This is a minimal **HelloWorld Servlet** project using **Maven (WAR)**.

- Default code is for **Tomcat 10+** (uses `jakarta.servlet.*`).
- If you use **Tomcat 9 or older**, switch to `javax.servlet.*` (instructions below).

## Run on IntelliJ / MyEclipse / NetBeans (Tomcat)

1. Import as Maven project.
2. Add a Tomcat Server in your IDE.
3. Deploy artifact as **WAR exploded** (IntelliJ) or **Run on Server** (MyEclipse/NetBeans).
4. Open:
   - `http://localhost:8080/HelloServlet/hello`

## Build WAR (optional)
```bash
mvn clean package
```
WAR will be in: `target/HelloServlet-1.0.war`

## If you use Tomcat 9 (javax)

### Step 1: Change imports in `HelloServlet.java`
Replace:
- `jakarta.servlet.*` -> `javax.servlet.*`

### Step 2: Replace dependency in `pom.xml` with:
```xml
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>
```

## Endpoint
- `/hello` -> prints: `Hello World from Servlet!`
