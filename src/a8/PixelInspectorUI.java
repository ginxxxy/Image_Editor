package a8;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorUI extends JPanel {

	private JLabel x_label;
	private JLabel y_label;
	private JLabel pixel_info;
	private JButton copybutton;
	private PictureView mag;
	private JPanel main;
	
	
	public PixelInspectorUI() {
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		copybutton = new JButton("copy");
		Picture p = new PictureImpl(100,100);
		mag = new PictureView(p.createObservable());
		main = new JPanel();
		

		main.setLayout(new GridLayout(3,1));
		main.add(x_label);
		main.add(y_label);
		main.add(pixel_info);
		this.setLayout(new GridLayout(0,1));
		this.add(main);
		this.add(mag);
		this.add(copybutton);
	}
	
	public void setInfo(int x, int y, Pixel p) {
		x_label.setText("X: " + x);
		y_label.setText("Y: " + y);
		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));		
	}
	
	public JButton getButton(){
		return this.copybutton;
	}
	
	public void setMag(Picture p){
		for (int i = 0; i < mag.getPicture().getHeight(); i++) {
			for (int j = 0; j < mag.getPicture().getWidth(); j++) {
				mag.getPicture().setPixel(j, i, p.getPixel(j, i));
			}
		}
		
	}
}
