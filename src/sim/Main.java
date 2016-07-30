package sim;

import org.opencv.core.Core;

import interfaces.ConfigFileReader;
import interfaces.MyRobot;
import interfaces.RobotProvider;

public class Main {
	
	private static GameState state_ = GameState.Disabled;
	private static boolean init = true;

	private enum GameState{
		Disabled, Teleop, Auton, Test
	}
	
	
	//Pass in robot name as argument
	public static void main(String[] args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		if(args.length < 1){
			System.out.println("You must pass in the robot name!");
			return;
		}
		
		ConfigFileReader.fileName = "config.txt";
		RobotProvider.instance = new SimRobotProvider();
		
		System.out.println("========== Loading Robot Code ==========");
		MyRobot robot;
		try {
			robot = (MyRobot)Class.forName(args[0]).newInstance();
		} catch (Throwable t) {
			System.out.println("Robot couldn't be instantiated\t :(");
			return;
		}
		
		System.out.println("========== Starting up connector ==========");
		new Thread(VRConnector.getInstance()).start();
		
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
		}
	}
}
