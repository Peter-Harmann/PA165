## Seminar 01 Tasks 
**Task 01** Open IDE. Main IDE for this course is IntelliJ IDEA. This IDE is installed in B130 and accessible through modules. Use the following commands to run IDE. Create hello world Java application and run it using the IDE.
```
  module add idea-2018.2 maven-3.5
  idea.sh &
```
The IntelliJ IDEA needs a licence. If you don't already have one, just visit https://www.jetbrains.com/student/ and create a new JetBrains account with an email from the domain @mail.muni.cz, you will get a student licence for all JetBrains products for one year.
Note: its a good idea to put the `module add` command into your ~/.bashrc

**Task 02** Find out which version of Maven is installed on your machine using `which mvn`. You MUST use terminal where you added the module from Task 01. Notes: Maven was covered on the lecture. The module from Task 01 adds the Maven on your system path. This means that you must add module from Task 01 in EVERY terminal that you will be using for running netbeans or for running any Maven commands. Other notes: your local maven repo is in `~/.m2`.

**Task 03** Create hello world Java application using Maven from command line. Use "archetype" [look at documentation](https://maven.apache.org/archetype/maven-archetype-plugin/usage.html) plugin and goal "generate". With every maven plugin, including the arechetype, its beneficial to review [usage page of documentation](https://maven.apache.org/archetype/maven-archetype-plugin/usage.html#). Run this application from commandline using Maven exec plugin goal java [mvn exec:java](https://www.mojohaus.org/exec-maven-plugin/usage.html). Note that you must firstly compile the source code using `mvn compile`.

**Task 04** Create an acount on https://github.com/. Create a repository there. Import the hello world application from Task 03 to this repository. Hints: http://readwrite.com/2013/09/30/understanding-github-a-journey-for-beginners-part-1

**Task 05** Checkout git branch seminar01 from https://github.com/fi-muni/PA165 (use git clone and then git checkout). Use https git URL. This branch contains 2 projects. hello-java7 and hello-tom-web. 
```
cd
git clone https://github.com/fi-muni/PA165
cd PA165
git checkout seminar01
```

**Task 06** Try to compile hello-java7 `mvn clean compile`. It will fail, because the default configuration of maven is not to use source and target level of Java 1.7. To fix that we need to configure compiler plugin in pom.xml so that target and source versions of java are at least 7. [See documentation and configure your the pom.xml](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html). After you successfully configure the pom.xml it should be able to compile the project with `mvn compile` 

**Task 07** Now your task is to configure embedded Tomcat 8 using Cargo plugin in `hello-tom-web` project. After its configured, you will be able to start the embedded Tomcat 8 and hello-tom-web will be accessible through web browser. Import the project into your IDE and after that configure cargo-maven2-plugin in version 1.6.8 with configuration: 

```
          <container>
            <containerId>tomcat8x</containerId>
            <artifactInstaller>
              <groupId>org.apache.tomcat</groupId>
              <artifactId>tomcat</artifactId>
              <version>8.5.31</version>
            </artifactInstaller>
          </container>

```

After that use `mvn clean install cargo:run` go to `http://localhost:8080/my-webapp/hello` and you should see "Hello world!". Next task is to make additional configuration to cargo-maven2-plugin to publish the app on different context `/my-different-context`. This is the configuration you need to add: 
```
          <deployables>
            <deployable>
              <properties>
                <context>/my-different-context</context>
              </properties>
            </deployable>
          </deployables>

```
After you correctly configure and re-run the app, you will see the hello world on `http://localhost:8080/my-different-context/hello`
