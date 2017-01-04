package sim;

import interfaces.JoystickReader;

public class Joystick implements JoystickReader{

	private int port;
	private final double[] values = new double[]{0, -1, 1};
	
	int index = -1;
	int calls = 0;
	
	public Joystick(int port){
		this.port = port;
	}
	
	@Override
	public double getRawAxis(int axis) {
		return 0;
		
//		if(index >= values.length)
//			return 0;
//		
//		if(calls % 100 == 0)
//			index++;
//		calls++;
//		
//		System.out.println("Index: " + index + "\tValue: " + values[index]);
//		return values[index];
	}

	@Override
	public boolean getRawButton(int button) {
		return false;
	}

}
