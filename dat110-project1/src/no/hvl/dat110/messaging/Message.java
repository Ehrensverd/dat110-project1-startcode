package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		// TODO: check for length within boundary
		//
		if(payload.length <= MessageConfig.SEGMENTSIZE)	// Ensure payload is less than or equal to 127 bytes
			this.payload = payload;
		//
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = null;


		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		//
		encoded = new byte[MessageConfig.SEGMENTSIZE];  // 128
		byte payload_size = (byte)this.payload.length;
		encoded[0] = payload_size; // Add metadata and encapsulate
		System.arraycopy(this.payload, 0, encoded, 1, payload_size); // Copy from array to array
		//

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message
		//
		this.payload = new byte[(int)received[0]]; // get payload size and make empty payload array
		System.arraycopy(received, 1, this.payload, 0, this.payload.length); // Copy from array to array
		//

		throw new UnsupportedOperationException(TODO.method());

	}
}
