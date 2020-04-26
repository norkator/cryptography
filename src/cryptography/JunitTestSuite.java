/**
 * Declare test classes here
 */
package cryptography;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cryptography.caesar.CaesarTest;
import cryptography.chaocipher.ChaocipherTest;
import cryptography.gronsfeld.GronsfeldTest;
import cryptography.scytale.ScytaleTest;
import cryptography.vigenere.VigenereTest;
import cryptography.railfence.RailFenceTest;
import cryptography.atbash.AtbashTest;
import cryptography.autokey.AutokeyTest;
import cryptography.bacon.BaconTest;
import cryptography.beaufort.BeaufortTest;
import cryptography.keyword.KeywordTest;

@RunWith(Suite.class)
@SuiteClasses({
	CaesarTest.class, 
	ScytaleTest.class,
	RailFenceTest.class,
	AtbashTest.class,
	AutokeyTest.class,
	BeaufortTest.class,
	KeywordTest.class,
	VigenereTest.class,
	BaconTest.class,
	ChaocipherTest.class,
	GronsfeldTest.class,
})
public class JunitTestSuite {

}
