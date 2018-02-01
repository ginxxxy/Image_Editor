package a8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintBrushTool implements Tool {

	private PaintBrushToolUI ui;
	private ImageEditorModel model;
	private int brush_size = 5;
	
	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new PaintBrushToolUI();
		this.model.setOpacity(this.ui.getOpacitySlider().getValue());
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(model.getStack().isEmpty()){
			this.model.push(this.model.getCurrent());
		}
			this.model.push(this.model.getCurrent());
			model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), brush_size);
		
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
		if(model.getStack().isEmpty()){
			this.model.push(this.model.getCurrent());
		}
		this.model.push(this.model.getCurrent());	
			model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), brush_size);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}
	public void copyPixel(Pixel p) {
		this.ui.copyPixel(p);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (!this.model.getStack().isEmpty()) {
			Picture p = this.model.pop();
			
			
			for (int i = 0; i < p.getHeight(); i++) {
				for (int j = 0; j < p.getWidth(); j++) {
					this.model.getCurrent().setPixel(j, i, p.getPixel(j, i));
				}
			}
		}
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		brush_size = ui.getSizeSlider().getValue();
		int a = ui.getOpacitySlider().getValue();
		this.model.setOpacity(a);
	}

	public void addActionListener(ActionListener l) {
		this.ui.getButton().addActionListener(l);
	}

	public void addChangeListener(ChangeListener l) {
		this.ui.getSizeSlider().addChangeListener(l);
		this.ui.getOpacitySlider().addChangeListener(l);
	}
	
}
