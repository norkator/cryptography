package cryptography;

import cryptography.hashes.crc.CRCHashes;

public class Hashes {

	public static void main(String[] args) {

		// CRC-8
		System.out.println("CRC-8 hash: " + CRCHashes.crc8("test"));
		
		// CRC-16
		System.out.println("CRC-16 hash: " + CRCHashes.crc16("test"));
	
		// CRC-24
		System.out.println("CRC-24 hash: " + CRCHashes.crc24("test"));
	
		// CRC-32
		System.out.println("CRC-32 hash: " + CRCHashes.crc32("test"));
	
		// CRC-64
		System.out.println("CRC-64 hash: " + CRCHashes.crc64("testing"));
	

	}

}
