package a8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

public class PixelInspectorTool implements Tool {

	private PixelInspectorUI ui;
	private ImageEditorModel model;
	
	public PixelInspectorTool(ImageEditorModel model) {
		this.model = model;
		ui = new PixelInspectorUI();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			Pixel a = model.getPixel(e.getX(), e.getY());
			ui.setInfo(e.getX(), e.getY(), a);
			model.setTemp(a);
			int x = e.getX()-50;
			int y = e.getY()-50;
			if(x<0){
				x= 0;
			}
			if(y<0){
				y=0;
			}
			if (y + 100 > model.getCurrent().getHeight()) {
				y = model.getCurrent().getHeight() - 100;
			}
			if (x + 100 > model.getCurrent().getWidth()) {
				x = model.getCurrent().getWidth() - 100;
			}
			Picture magPic = model.getCurrent().extract(x,y,100,100);
			magPic = magnify(magPic);
			ui.setMag(magPic);
			
		}
		catch (Exception ex) {
			// Click may have been out of bounds. Do nothing in this case.
		}
	}

	private Picture magnify(Picture p) {
		// TODO Auto-generated method stub
		Picture mag = new PictureImpl(p.getWidth()*2,p.getHeight()*2);
		for(int i = 0;i<mag.getHeight();i++){
			for(int j = 0;j<mag.getWidth();j++){
				Pixel temp = p.getPixel(j/2,i/2);
				mag.setPixel(j, i,temp);
			}
		}
		return mag;
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
	public String getName() {
		return "Pixel Inspector";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			Pixel a = model.getPixel(e.getX(), e.getY());
			ui.setInfo(e.getX(), e.getY(), a);
			model.setTemp(a);
			int x = e.getX()-50;
			int y = e.getY()-50;
			if(x<0){
				x= 0;
			}
			if(y<0){
				y=0;
			}
			if (y + 100 > model.getCurrent().getHeight()) {
				y = model.getCurrent().getHeight() - 100;
			}
			if (x + 100 > model.getCurrent().getWidth()) {
				x = model.getCurrent().getWidth() - 100;
			}
			Picture magPic = model.getCurrent().extract(x,y,100,100);
			magPic = magnify(magPic);
			ui.setMag(magPic);
			
		}
		catch (Exception ex) {
			// Click may have been out of bounds. Do nothing in this case.
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		model.setFina(model.getTemp());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void addActionListener(ActionListener l){
		ui.getButton().addActionListener(l);
	}

}
