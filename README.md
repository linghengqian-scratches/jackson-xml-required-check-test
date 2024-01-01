# jackson-xml-required-check-test

- For https://github.com/apache/shardingsphere/pull/29384 and https://github.com/FasterXML/jackson-dataformat-xml/issues/625 .

- Execute the following command on the Ubuntu 22.04.3 instance with `SDKMAN!` installed.

```shell
sdk install java 17.0.9-graalce
sdk use java 17.0.9-graalce

git clone git@github.com:linghengqian/jackson-xml-required-check-test.git
cd ./jackson-xml-required-check-test/
./mvnw clean test
```

- Get Error.
```shell
$ ./mvnw clean test
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< com.lingh:jackson-xml-required-check-test >--------------
[INFO] Building jackson-xml-required-check-test 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ jackson-xml-required-check-test ---
[INFO] Deleting /home/linghengqian/TwinklingLiftWorks/git/public/jackson-xml-required-check-test/target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ jackson-xml-required-check-test ---
[INFO] skip non existing resourceDirectory /home/linghengqian/TwinklingLiftWorks/git/public/jackson-xml-required-check-test/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ jackson-xml-required-check-test ---
[INFO] No sources to compile
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ jackson-xml-required-check-test ---
[INFO] skip non existing resourceDirectory /home/linghengqian/TwinklingLiftWorks/git/public/jackson-xml-required-check-test/src/test/resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ jackson-xml-required-check-test ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 1 source file with javac [debug target 17] to target/test-classes
[INFO] 
[INFO] --- surefire:3.1.2:test (default-test) @ jackson-xml-required-check-test ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.lingh.RequiredTest
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.304 s <<< FAILURE! -- in com.lingh.RequiredTest
[ERROR] com.lingh.RequiredTest.assertRequiredValue -- Time elapsed: 0.276 s <<< FAILURE!
org.opentest4j.AssertionFailedError: Expected com.fasterxml.jackson.databind.exc.MismatchedInputException to be thrown, but nothing was thrown.
        at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:152)
        at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:73)
        at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:35)
        at org.junit.jupiter.api.Assertions.assertThrows(Assertions.java:3115)
        at com.lingh.RequiredTest.assertRequiredValue(RequiredTest.java:21)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Failures: 
[ERROR]   RequiredTest.assertRequiredValue:21 Expected com.fasterxml.jackson.databind.exc.MismatchedInputException to be thrown, but nothing was thrown.
[INFO] 
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.282 s
[INFO] Finished at: 2023-12-28T11:25:23+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.1.2:test (default-test) on project jackson-xml-required-check-test: There are test failures.
[ERROR] 
[ERROR] Please refer to /home/linghengqian/TwinklingLiftWorks/git/public/jackson-xml-required-check-test/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

```