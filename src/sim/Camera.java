package sim;

import interfaces.CameraReader;

import org.opencv.core.Mat;

public class Camera implements CameraReader{

	private String id;
	
	public Camera(String id){
		this.id = id;
	}
	
	@Override
	public Mat getImage() {
		if(id.equals("axisCamera")){
			//return images of goal
		}
		else{
			//images of front intake - or whatever the usb camera sees
		}
		return null;
	}

}
