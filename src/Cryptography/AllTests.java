package cryptography;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cryptography.caesar.CaesarJUnit;

@RunWith(Suite.class)
@SuiteClasses({CaesarJUnit.class})
public class AllTests {
	
}
