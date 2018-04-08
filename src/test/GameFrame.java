package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {  //GUI编程AWT swing
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
	
	private  double x,y; 
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		Font f =new Font("黑体",Font.BOLD,100);//建立字体
		g.setFont(f);//设置字体
		g.drawString("sdsd", 200, 200);//写字
		g.fillRect(100, 100, 20, 20);//长方体
		Color c = g.getColor();//颜色
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);//圆体
		g.setColor(c);
		g.drawImage(img, (int)x,(int)y, null);
		x+=3;y+=3;
	}
	///重画窗口的线程类，是一个内部类
 class PaintThread extends Thread{
	 public void run() {
		 while(true) {
			 repaint();
			 try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
 }


	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
