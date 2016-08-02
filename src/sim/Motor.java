package sim;

import interfaces.SpeedController;

public class Motor implements SpeedController{

	private int port;
	
	public Motor(int port){
		this.port = port;
	}
	
	@Override
	public double get() {
		return 0;
	}

	@Override
	public void set(double speed, byte syncGroup) {
	}

	@Override
	public void set(double speed) {
		VRConnector.getInstance().putCommandFloat(port, (float)speed);
	}

	@Override
	public void setInverted(boolean isInverted) {
	}

	@Override
	public boolean getInverted() {
		return false;
	}

	@Override
	public void stopMotor() {
	}

}
