package sim;

import lib.ConstantsFileReader;

import org.opencv.core.Core;

import interfaces.ConfigFileReader;
import interfaces.MyRobot;
import interfaces.RobotProvider;

public class Main {
	
	private static final int WAIT_TIME = 3;	//seconds
	
	private static GameState state_ = GameState.Auton;
	private static boolean init = true;

	private enum GameState{
		Disabled, Teleop, Auton, Test
	}
	
	//Pass in robot name as argument
	public static void main(String[] args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		if(args.length < 1){
			System.out.println("You must pass in the robbit's name!");
			return;
		}
		
		ConfigFileReader.fileName = "simConfig.txt";
		ConstantsFileReader.fileName = "simConstants.csv";
		RobotProvider.instance = new SimRobotProvider();
		
		System.out.println("========= Loading Robbit Code =========");
		MyRobot robot = null;
		try {
			robot = (MyRobot)Class.forName(args[0]).asSubclass(MyRobot.class).newInstance();
		} catch (Exception e) {
			System.out.println("Robot couldn't be instantiated\t :(");
			e.printStackTrace();
			return;
		}
		
		System.out.println("========== Starting up connector ==========");
		new Thread(VRConnector.getInstance()).start();
		VRConnector.getInstance().putCommandBool(VRConnector.RESET_SIM, true);		

		
		/*
		 * RESETING SIMULATOR
		System.out.println("Waiting for Simulator to restart...");
		for(int i = WAIT_TIME; i > 0; i--){
			System.out.println(i + " seconds left...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {}
		}
		*/
		
		robot.robotInit();
		
		while(true){
			//Update GameState
//			if(state_ != VRConnector.getInstance().getFeedback(VRConnector.Game_State))
//				init = true;
			
			switch(state_){
				case Auton:
					if(init)
						robot.autonomousInit();
					robot.autonomousPeriodic();
					break;
				case Disabled:
					if(init)
						robot.disabledInit();
					robot.disabledPeriodic();
					break;
				case Teleop:
					if(init)
						robot.teleopInit();
					robot.teleopPeriodic();
					break;
				case Test:
					if(init)
						robot.testInit();
					robot.teleopPeriodic();
					break;
				default:
					System.err.println("GAME STATE NOT RECOGNIZED:\t" + state_);
					break;
			}
			init = false;
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
