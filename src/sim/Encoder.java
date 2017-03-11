package sim;

import interfaces.EncoderReader;

public class Encoder implements EncoderReader{

	private int port1, port2;
	
	private int offset = 0;
	
	public Encoder(int port1, int port2){
		this.port1 = port1;
		this.port2 = port2;
	}
	
	@Override
	public int getRaw() {
		return VRConnector.getInstance().getFeedback(port1) - offset;
	}

	@Override
	public int get() {
		return VRConnector.getInstance().getFeedback(port1) - offset;
	}

	@Override
	public void reset() {
		offset = VRConnector.getInstance().getFeedback(port1);
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
