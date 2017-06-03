package sim;

import interfaces.DigitalOut;

public class DigitalOutput implements DigitalOut{

	private int port;
	
	public DigitalOutput(int port){
		this.port = port;
	}
	
	@Override
	public void set() {
	}
	
}
