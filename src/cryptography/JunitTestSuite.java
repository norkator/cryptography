/**
 * Declare test classes here
 */
package cryptography;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cryptography.ciphers.caesar.CaesarTest;
import cryptography.ciphers.chaocipher.ChaocipherTest;
import cryptography.ciphers.gronsfeld.GronsfeldTest;
import cryptography.ciphers.scytale.ScytaleTest;
import cryptography.ciphers.vigenere.VigenereTest;
import cryptography.encoding.base32.Base32Test;
import cryptography.encoding.base64.Base64Test;
import cryptography.encoding.base85.Base85Test;
import cryptography.encoding.base91.Base91Test;
import cryptography.encoding.a1z26.A1z26Test;
import cryptography.ciphers.railfence.RailFenceTest;
import cryptography.ciphers.adfgvx.AdfgvxTest;
import cryptography.ciphers.atbash.AtbashTest;
import cryptography.ciphers.autokey.AutokeyTest;
import cryptography.ciphers.bacon.BaconTest;
import cryptography.ciphers.beaufort.BeaufortTest;
import cryptography.ciphers.keyword.KeywordTest;
import cryptography.ciphers.playfair.PlayfairTest;

@RunWith(Suite.class)
@SuiteClasses({
	// --------------------------
	// Ciphers
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
	AdfgvxTest.class,
	PlayfairTest.class,
	// --------------------------
	// Hashes
	// --------------------------
	// Encoding
	Base32Test.class,
	Base64Test.class,
	Base85Test.class,
	Base91Test.class,
	A1z26Test.class,
})
public class JunitTestSuite {

}
