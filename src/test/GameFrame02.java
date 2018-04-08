package test;
/**
 * 各种移动图片
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame02 extends Frame {  //GUI编程AWT swing
	Image img = GameUtil.getImages("images/sun.jpg");//加载图
	
	public void launchFrame() {//设置窗口
		setSize(500,500);//窗口大小
		setLocation(100,100);//窗口起点
		setVisible(true);//窗口可视化
		
		
		new PaintThread().start();//调用线程
		/**
		 * 关闭窗口按键
		 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private  double x=100,y=100; 
	//int z=0;//左右方向变量
	private double  degree=3.14/3;
	private double speed=30.0;
	@Override
	public void paint(Graphics g) {
		g.drawOval(100, 100, 200, 400);
		g.drawImage(img, (int)x,(int)y, null);
		//左右和上下飞
		/*if(x>=400) {
		z=1;
		}else if(x<=0){
			z=0;
		}
		if(z==1) {
			x-=30;
			}else if(z==0){
				x+=30;
			}*/
		//停下来
		/*if(speed>0) {
			speed -=0.1; 
		}else {
			speed =0;
		}
*/		//角度
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		//台球移动
		
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
		}

		
		
		}
	///重画窗口的线程类，是一个内部类
 class PaintThread extends Thread{
	 public void run() {
		 while(true) {
			 repaint();
			 try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
 }


	public static void main(String[] args) {
		GameFrame02 gf = new GameFrame02();
		gf.launchFrame();
	}
}
