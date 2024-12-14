### Maven
- Maven is a build automation tool used primarily for Java projects.
- It simplifies the process of managing project dependencies, compiling code, running tests, and packaging applications.
- Maven follows a convention-over-configuration approach, meaning it provides a standard structure for your projects to minimize 
 configuration overhead.

**Key Concepts:**
- **POM (Project Object Model):** A pom.xml file is the heart of a Maven project.
- It contains information about the project and configuration details for plugins and dependencies.

- **Dependencies:** Maven allows you to manage external libraries your project needs.
- Instead of manually downloading and managing jar files, Maven automatically downloads them from a central repository (Maven Central).

- **Build Lifecycle:** Maven defines a standard sequence of tasks (compile, test, package, deploy).
- It helps automate these processes.

**How Maven Works:**
- You define your project’s dependencies, build instructions, and plugins in the pom.xml file.

**Maven downloads any required libraries automatically.**
- It compiles the project and runs the tests defined in your project structure.
- It can also create JAR/WAR files for distribution.

**Benefits of Using Maven:**
- Dependency Management: Automatically handles downloading and updating dependencies.
- Project Standardization: Provides a standardized project structure.
- Automation: Automates compilation, testing, packaging, and deployment.

### JUnit
- JUnit is a testing framework for Java.
- It helps you write repeatable and automated tests for your Java code.
- JUnit is used to ensure that your application is working as expected by running unit tests.
- Unit tests test individual units or components (e.g., methods) of your application.

**Key Concepts:**
- **Test Class:** A Java class that contains test methods to check the functionality of your application.
- **Test Method:** A method that contains logic for testing a small piece of functionality.
- **Assertions:** Statements that check if your code behaves as expected (e.g., assertEquals, assertTrue).
- **Test Runner:** JUnit provides a test runner that executes your tests and reports the results.

**JUnit 5:**
- JUnit 5 is the latest version of JUnit. It is modular and consists of:

- **JUnit Platform:** Defines the foundation for launching testing frameworks.
- **JUnit Jupiter:** The programming model and extension model for writing tests.
- **JUnit Vintage:** Support for running JUnit 3 and JUnit 4 tests.

**Key Annotations:**
- **@Test:** Marks a method as a test method.
- **@BeforeEach:** Runs before each test.
- **@AfterEach:** Runs after each test.
- **@BeforeAll:** Runs once before all tests in the class.
- **@AfterAll:** Runs once after all tests in the class.

**How Maven and JUnit Work Together**
- Maven manages the dependencies (like JUnit) and automates the build and test process.
- JUnit runs tests defined in the project, and Maven can trigger JUnit tests as part of the build lifecycle.

**For example, you can use Maven to:**

- Compile your Java code.
- Run your JUnit tests.
- Package the application into a JAR/WAR file.
- Integrating JUnit with Maven:
- add JUnit as a dependency in your pom.xml file.
- When you run mvn test, Maven will automatically discover and execute JUnit tests.
