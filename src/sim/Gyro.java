package sim;

import interfaces.GyroReader;

public class Gyro implements GyroReader{

	private int port;
	
	public Gyro(int port){
		this.port = port;
	}
	
	@Override
	public void calibrate() {
	}

	@Override
	public void reset() {
	}

	@Override
	public double getAngle() {
		return VRConnector.getInstance().getFeedback(port);
	}

	@Override
	public double getRate() {
		return 0;
	}

}
