### Jar (Java ARchive)

- A JAR (Java ARchive) file is a package that contains Java class files, resources (images, configuration files, etc.), and metadata in a compressed format similar to a ZIP file.
- JAR files are mainly used to distribute Java applications and libraries.

### Why Use JAR Files?

- ```Efficient Packaging``` – Combines multiple .class files into a single file.
- ```Compression``` – Reduces file size using ZIP compression.
- ```Portability ``` – Allows Java applications to be easily shared.
- ```Manifest Metadata ```– Stores configuration (e.g., specifying the main class).
- ```Code Reusability ```– JARs can be used as dependencies in other projects (like in Maven).

### How to Create a JAR project Using Maven?

***setup pom.xml file for jar to use maven***

- ***Example***
```
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.3.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>com.example.MainClass</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

***Create a JAR:**
- Run ```mvn clean package``` command : This will create the JAR file in the target directory: .

***Run the JAR:***
- Run ```java -jar target/my-java-project-1.0-SNAPSHOT.jar``` command : to run the targaet jar file.

***Pass System Property:*** 
- Run ```java -DmyProperty=HelloWorld -jar target/my-java-project-1.0-SNAPSHOT.jar``` command to pass system property .

***Expand JAR: ***
- Run ```jar -xf <target>``` or ```unzip``` to extract jar file. 

