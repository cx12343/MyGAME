package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {  //GUI���AWT swing
	Image img = GameUtil.getImages("images/sun.jpg");//����ͼ
	
	public void launchFrame() {//���ô���
		setSize(500,500);//���ڴ�С
		setLocation(100,100);//�������
		setVisible(true);//���ڿ��ӻ�
		
		
		new PaintThread().start();//�����߳�
		/**
		 * �رմ��ڰ���
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
		Font f =new Font("����",Font.BOLD,100);//��������
		g.setFont(f);//��������
		g.drawString("sdsd", 200, 200);//д��
		g.fillRect(100, 100, 20, 20);//������
		Color c = g.getColor();//��ɫ
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);//Բ��
		g.setColor(c);
		g.drawImage(img, (int)x,(int)y, null);
		x+=3;y+=3;
	}
	///�ػ����ڵ��߳��࣬��һ���ڲ���
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
