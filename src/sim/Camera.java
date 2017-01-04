package sim;

import interfaces.CameraReader;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * Grabs images from the robot camera
 * http://localhost:7663/
 * 
 * @author Brett Levenson
 *
 */
public class Camera implements CameraReader{

	private String id;
	
	public Camera(String id){
		this.id = id;
	}
	
	@Override
	public Mat getImage() {
		if(id.equals("axisCamera")){
			try {
				URL url = new URL("http://localhost:7663/");
				BufferedImage image = ImageIO.read(url);
				return bufferedImageToMat(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//return images of goal
		}
		else{
			//images of front intake - or whatever the usb camera sees
		}
		return null;
	}
	
	private Mat bufferedImageToMat(BufferedImage bi) {
		  Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
		  byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
		  mat.put(0, 0, data);
		  return mat;
	}

}
