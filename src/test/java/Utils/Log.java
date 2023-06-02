package Utils;

import org.apache.log4j.*;

public class Log {

    public static Logger log=Logger.getLogger(Log.class.getName());
    //when my test starts , I should print the logs
    //When my test stops I should print the logs
    //If I want to print any message in between, I should print the logs

    public static void startTestCase(String testCaseName)
    {
        log.info("**********************");
        log.info("**********************");
        log.info("*********"+testCaseName+"**********");
    }

    public static void endTestCase(String testCaseName)
    {
        log.info("###################");
        log.info("###################");
        log.info("#########"+testCaseName+"#############");
    }

    public static void info(String message)
    {
        log.info("message");

    }
    public static void warning(String warning)
    {
        log.info("warning");

    }
    //======================Maven LIFECYCLE==================
    //MAVEN LIFE CYCLE consists of several phases
    //clean:Removes all the files generated by the previous build
    //validate: Checks the project is correct all the necessary  information is available
    //compile:compiles source code of rhe project
    //test:runs the tests for the project
    //package: packages the compiled code into a distributables format, such as JAR or WAR file
    //verify:runs and checks on results of integration tests to ensure quality criteria is met
    //install:installs the pckges into local repository
    //deploy:copies the final pckage to remote repository for sharing with other developers

}
