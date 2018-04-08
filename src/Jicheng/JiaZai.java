package Jicheng;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;

public class JiaZai extends Frame {
	public void launchFrame() {//设置窗口
		setSize(Constant.GAME_HIHGT,Constant.GAME_WIDTH);//窗口大小
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
}
