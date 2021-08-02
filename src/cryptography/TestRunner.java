/**
 * Use JUnit4
 */
package cryptography;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.security.Security;

public class TestRunner {
    public static void main(String[] args) {

        // Allows use of tougher crypto
        Security.setProperty("crypto.policy", "unlimited");

        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Tests success: " + result.wasSuccessful());
    }
}
