/**
 * Declare test classes here
 */
package cryptography;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cryptography.caesar.CaesarTest;
import cryptography.scytale.ScytaleTest;

@RunWith(Suite.class)
@SuiteClasses({
	CaesarTest.class, 
	ScytaleTest.class
})
public class JunitTestSuite {
	
}
