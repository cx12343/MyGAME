package test;
/**
 * �����ƶ�ͼƬ
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame02 extends Frame {  //GUI���AWT swing
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
	
	private  double x=100,y=100; 
	//int z=0;//���ҷ������
	private double  degree=3.14/3;
	private double speed=30.0;
	@Override
	public void paint(Graphics g) {
		g.drawOval(100, 100, 200, 400);
		g.drawImage(img, (int)x,(int)y, null);
		//���Һ����·�
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
		//ͣ����
		/*if(speed>0) {
			speed -=0.1; 
		}else {
			speed =0;
		}
*/		//�Ƕ�
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		//̨���ƶ�
		
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
	///�ػ����ڵ��߳��࣬��һ���ڲ���
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
