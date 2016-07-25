package sim;

import interfaces.SolenoidController;

public class Solenoid implements SolenoidController{

	private int port;
	private boolean state;
	
	public Solenoid(int port){
		this.port = port;
	}
	
	@Override
	public void set(boolean on) {
		switch(port){
			//Drive Shifter
			case 6:
//				VRConnector.getInstance().putCommandBool(VRConnector.DRIVE_SHIFTER, on);
				break;
			default:
				System.out.println("Solenoid port " + on + " not recognized");
				return;
		}
		state = on;
	}

	@Override
	public boolean get() {
		return state;
	}

}
