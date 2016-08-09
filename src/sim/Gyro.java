package sim;

import interfaces.GyroReader;

public class Gyro implements GyroReader{

	private int port;
	private double offset = 0;
	
	public Gyro(int port){
		this.port = port;
	}
	
	@Override
	public void calibrate() {
	}

	@Override
	public void reset() {
		offset = VRConnector.getInstance().getFeedback(port);
	}

	@Override
	public double getAngle() {
//		System.out.println(VRConnector.getInstance().getFeedback(port) + "\t" + offset);		
		return VRConnector.getInstance().getFeedback(port) - offset;
	}

	@Override
	public double getRate() {
		return 0;
	}

}
