package no.hvl.dat110.system.sensor;

import java.util.Random;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class SensorImpl implements RPCImpl {

	static final int RANGE = 20;

	public int read() {

		return  new Random().nextInt(50) - 20;
	}
	
	public byte[] invoke(byte[] request) {
				
		RPCUtils.unmarshallVoid(request); 
		
		int temp = read();
		
		byte rpcid = request[0];
		
		byte[] reply = RPCUtils.marshallInteger(rpcid,temp); 
		
		return reply;
	}
}
