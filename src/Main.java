import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
    }

    private static String resultAsMessage(String testCaseName, double expected, double actual) {
        return expected == actual
                ? testCaseName + ": " + "\u001B[32m" + "PASS" + "\u001B[0m"
                : testCaseName + ": " + "\u001B[31m" + "FAIL" + "\u001B[0m" + " (expected " + expected + ", actual " + actual + ", ensure you have not changed related data)";
    }
}
