package DesignPatternsAndPrinciples.SingletonPatternExample;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");

        // Verifying both references point to the same instance
        System.out.println("Are both logger instances same? " + (logger1 == logger2));
    }
}
