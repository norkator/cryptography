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
import cryptography.encoding.huffman.HuffmanTest;
import cryptography.encoding.morse.MorseTest;
import cryptography.hashes.adler.AdlerTest;
import cryptography.hashes.blake2b.Blake2bTest;
import cryptography.hashes.crc.CRCTest;
import cryptography.hashes.elf.ELFTest;
import cryptography.hashes.fcs.FCSTest;
import cryptography.hashes.has.HASTest;
import cryptography.hashes.keccak.KeccakTest;
import cryptography.hashes.md.MDTest;
import cryptography.hashes.ripemd.RIPEMDTest;
import cryptography.hashes.sha.SHATest;
import cryptography.hashes.sha2.SHA2Test;
import cryptography.hashes.sha3.SHA3Test;
import cryptography.hashes.sm3.SM3Test;
import cryptography.hashes.sum.SUMTest;
import cryptography.hashes.tiger.TigerTest;
import cryptography.hashes.whirlpool.WhirlpoolTest;
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
	Blake2bTest.class,
	CRCTest.class,
	ELFTest.class,
	FCSTest.class,
	HASTest.class,
	KeccakTest.class,
	MDTest.class,
	RIPEMDTest.class,
	SHATest.class,
	SHA2Test.class,
	SHA3Test.class,
	SM3Test.class,
	SUMTest.class,
	TigerTest.class,
	WhirlpoolTest.class,
	XorTest.class,
	// --------------------------
	// Encoding
	A1z26Test.class,
	Base32Test.class,
	Base64Test.class,
	Base85Test.class,
	Base91Test.class,
	MorseTest.class,
	HuffmanTest.class,
})

public class JunitTestSuite {

}
