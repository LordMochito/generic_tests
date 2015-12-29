package com.codetests.algorithms.encoding;

import org.apache.commons.codec.binary.Base64;

public class Converter {

	public static void main(String[] args) {
		Converter converter = new Converter();
		String encoded = converter.encode("VHzNKTRpowNdcZWuTnHAFSBMmAtNkWuiCeuukvPK:biMcSqXJpFPEgJeNbWrBPgVVCYDdcwGbTlswWvNj");
		System.out.println(encoded);
		String decoded = converter.decode(encoded);
		System.out.println(decoded);
	}

	public String encode(String inputString) {
		byte[] encodedBytes = Base64.encodeBase64(inputString.getBytes());
		String resultEncodedString = new String(encodedBytes);
		return resultEncodedString;
	}
	
	public String decode(String inputString) {
		byte[] decodedBytes = Base64.decodeBase64(inputString);
		String resultdDecodedString = new String(decodedBytes);
		return resultdDecodedString;
	}
}
