package a8;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

public class BlurTool implements Tool  {
	
	private BlurToolUI ui;
	private ImageEditorModel model;
	private int blursize;
	

	public BlurTool(ImageEditorModel model){
		this.model = model;
		ui = new BlurToolUI();
		blursize = this.ui.getJSlider().getValue();
		ui.getJSlider().addChangeListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.model.getStack().isEmpty()) {
			this.model.push(this.model.getCurrent());
		}
		
		this.model.push(this.model.getCurrent());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		blursize = this.ui.getJSlider().getValue();
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Blur";
	}

	@Override
	public JPanel getUI() {
		// TODO Auto-generated method stub
		return ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
