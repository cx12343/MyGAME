package Jicheng;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameUtil {
	private GameUtil() {}//������ͨ���Ὣ���췽��˽��
	
	public static Image getImages(String path) {
		java.net.URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img=null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return img;
	}
}