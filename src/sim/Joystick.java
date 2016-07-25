package sim;

import interfaces.JoystickReader;

public class Joystick implements JoystickReader{

	private int port;
	
	public Joystick(int port){
		this.port = port;
	}
	
	@Override
	public double getRawAxis(int axis) {
		return 0;
	}

	@Override
	public boolean getRawButton(int button) {
		return false;
	}

}
