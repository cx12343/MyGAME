package Jicheng;
/**
 * ¸÷ÖÖÒÆ¶¯Í¼Æ¬
 */


import java.awt.Graphics;
import java.awt.Image;


public class GameFrame02 extends JiaZai {   
	Image img = GameUtil.getImages("images/sun.jpg"); 
	private  double x=300,y=300; 
	private double  degree=3.14;
	private double speed=10.0;
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x,(int)y, null);
		g.drawOval(200, 200, 200, 200);
		/*if(speed>0) {
			speed -=0.1; 
		}else {
			speed =0;
		}
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		
		
		if (y>500-70) {
			degree=-degree;
		}
		if(y<30){
			degree =-degree;
		}
		if(x<0) {
			degree=Math.PI-degree;
		}
		if(x>500-70) {
			degree= Math.PI -degree;
		}*/
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		degree+=0.1;
		
		
	}



	public static void main(String[] args) {
		GameFrame02 gf = new GameFrame02();
		gf.launchFrame();
	}
}
