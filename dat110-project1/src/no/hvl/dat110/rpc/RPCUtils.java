package no.hvl.dat110.rpc;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]

	/*
	RPCUtils.java containing utility methods for the unmarshalling and marshalling of the supported data types.
	The implementation of the marshalling/unmarshalling of booleans is provided and can be used for inspiration.
	Remember that an integer in Java is 4 bytes.
	 */
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;


		byte[] stringByteArray = str.getBytes();
		encoded = new byte[str.length() + 1]; // Possible trouble
		encoded[0] = rpcid;
		System.arraycopy(stringByteArray,0 ,encoded , 1 ,encoded.length );

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;
		byte[] temp = new byte[data.length -1];
		System.arraycopy(data, 1, temp, 0, temp.length);

		decoded = new String(temp);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;
		encoded = new byte[1];
		encoded[0] = rpcid;
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array

		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data

		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}

		return decoded;

	}
}
