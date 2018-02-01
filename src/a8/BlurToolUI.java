package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BlurToolUI extends JPanel implements ChangeListener{

	private JSlider bslider;
	

	public BlurToolUI(){
	setLayout(new GridLayout(0, 1));

	JPanel blur_panel = new JPanel();
	blur_panel.setLayout(new BorderLayout());

	JLabel blur_label = new JLabel("Blur size: ");
	bslider = new JSlider(0,100);
	bslider.setMajorTickSpacing(10);
	bslider.setPaintTicks(true);
	bslider.setPaintLabels(true);
	
	blur_panel.add(bslider,BorderLayout.CENTER);
	blur_panel.add(blur_label, BorderLayout.WEST);
	add(blur_panel);
	
}
	public JSlider getJSlider(){
		return bslider;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
