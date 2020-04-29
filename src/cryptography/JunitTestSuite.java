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
import cryptography.hashes.adler.AdlerTest;
import cryptography.hashes.crc.CRCHashesTest;
import cryptography.hashes.elf.ELFTest;
import cryptography.hashes.fcs.FCSTest;
import cryptography.hashes.has.HASTest;
import cryptography.hashes.md.MDHashesTest;
import cryptography.hashes.ripemd.RIPEMDHashesTest;
import cryptography.hashes.sha.SHAHashesTest;
import cryptography.hashes.sum.SUMHashesTest;
import cryptography.hashes.tiger.TigerHashesTest;
import cryptography.hashes.whirlpool.WhirlpoolHashesTest;
import cryptography.hashes.xor.XorTest;
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
	AdlerTest.class,
	CRCHashesTest.class,
	ELFTest.class,
	FCSTest.class,
	HASTest.class,
	MDHashesTest.class,
	RIPEMDHashesTest.class,
	SHAHashesTest.class,
	SUMHashesTest.class,
	TigerHashesTest.class,
	WhirlpoolHashesTest.class,
	XorTest.class,
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
