package sim;

import interfaces.EncoderReader;

public class Encoder implements EncoderReader{

	private int port1, port2;
	
	public Encoder(int port1, int port2){
		this.port1 = port1;
		this.port2 = port2;
	}
	
	@Override
	public int getRaw() {
		return 0;
	}

	@Override
	public int get() {
		return 0;
	}

	@Override
	public void reset() {
	}

	@Override
	public boolean getStopped() {
		return false;
	}

	@Override
	public boolean getDirection() {
		return false;
	}

	@Override
	public double getDistance() {
		return 0;
	}

	@Override
	public double getRate() {
		return 0;
	}

	@Override
	public void setDistancePerPulse(double distancePerPulse) {
	}

}
