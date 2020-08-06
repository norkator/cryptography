package cryptography.ciphers.elgamal;

import java.security.Security;

import cryptography.Mode;

public class Elgamal {
	
	
	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}


	public static void main(String[] args) {
	}

	
	public static String elgamal(String input, Mode mode) {

		if (mode == Mode.ENCRYPT) {
			
			org.spongycastle.jcajce.provider.asymmetric.ElGamal elgamal = new org.spongycastle.jcajce.provider.asymmetric.ElGamal();
			
			
		}

		if (mode == Mode.DECRYPT) {
			
			org.spongycastle.jcajce.provider.asymmetric.ElGamal elgamal = new org.spongycastle.jcajce.provider.asymmetric.ElGamal();
			
			
		}

		return "";
	}

	
}
