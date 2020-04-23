/**
 * Declare test classes here
 */
package cryptography;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cryptography.caesar.CaesarTest;
import cryptography.scytale.ScytaleTest;
import cryptography.railfence.RailFenceTest;

@RunWith(Suite.class)
@SuiteClasses({
	CaesarTest.class, 
	ScytaleTest.class,
	RailFenceTest.class,
})
public class JunitTestSuite {
	
}
