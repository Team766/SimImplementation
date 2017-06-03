package sim;

import interfaces.DigitalOut;

public class DigitalOutput implements DigitalOut{

	private int port;
	private boolean val;
	
	public DigitalOutput(int port){
		this.port = port;
		val = false;
	}
	
	@Override
	public void set(boolean out) {
		val = out;
	}
	
	@Override
	public boolean get(){
		return val;
	}
	
}
