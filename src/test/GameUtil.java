package test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	private GameUtil() {}//������ͨ���Ὣ���췽��˽��
	
	public static Image getImages(String path) {
		BufferedImage img=null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			img = javax.imageio.ImageIO.read(u);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return img;
	}
}
