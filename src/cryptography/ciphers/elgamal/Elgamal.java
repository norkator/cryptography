package cryptography.ciphers.elgamal;

import java.security.PublicKey;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;

import org.spongycastle.crypto.engines.ElGamalEngine;
import org.spongycastle.jcajce.provider.asymmetric.x509.KeyFactory;

import cryptography.Mode;

public class Elgamal {
	
	
	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	
	public static String elgamal(Mode mode, String input, String key) {
		String output = "";


		if (mode == Mode.ENCRYPT) {


			
	
		}

		if (mode == Mode.DECRYPT) {
			
			org.spongycastle.jcajce.provider.asymmetric.ElGamal elgamal = new org.spongycastle.jcajce.provider.asymmetric.ElGamal();
			
			
		}

		return "";
	}

	
}
