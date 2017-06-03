package sim;

import interfaces.RelayOutput;

public class Relay implements RelayOutput{

	private int port;
	private Value val;
	
	public Relay(int port){
		this.port = port;
		val = Value.kOff;
	}
	
	@Override
	public void set(Value out) {
		val = out;
	}
	
	public Value get(){
		return val;
	}
	
}
