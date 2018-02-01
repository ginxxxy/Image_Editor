package a8;

import java.util.Stack;


public class ImageEditorModel {

	private Picture original;
	private ObservablePicture current;
	private Pixel temp;
	private Pixel fina;
	private int opacity;
	private Stack<Picture> spicture;
	public ImageEditorModel(Picture p) {
		original = p;
		current = original.copy().createObservable();
		temp = new ColorPixel(0.0,0.0,0.0);
		fina = new ColorPixel(0.0,0.0,0.0);
		spicture = new Stack<Picture>();
		push(current);
		
		
		
	}

	public void push(Picture p) {
		// TODO Auto-generated method stub
		this.spicture.push(p.copy());
	}
	
	public Picture pop(){
		return this.spicture.pop();
	}
	
	public Stack<Picture> getStack(){
		return this.spicture;
	}
	
	public void setOpacity(int p){
		this.opacity = p;
	}

	public ObservablePicture getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size) {
		current.suspendObservable();
		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					Pixel temp = blend(brushColor,current.getPixel(xpos,ypos),opacity);
					current.setPixel(xpos, ypos, temp);
				}
			}
		}
		current.resumeObservable();
	}

	public void setTemp(Pixel p) {
		// TODO Auto-generated method stub
		this.temp = p;
		
	}
	public Pixel getTemp(){
		return temp;
	}

	public void setFina(Pixel p) {
		// TODO Auto-generated method stub
		this.fina = p;
	}
	public Pixel getFina(){
		return fina;
	}
	
	public Pixel blend(Pixel a, Pixel b, int opacity){
		double red = a.getRed() * opacity / 100.0 + b.getRed() * (1 - (opacity / 100.0));
		double green = a.getGreen() * opacity / 100.0 + b.getGreen() * (1 - (opacity / 100.0));
		double blue = a.getBlue() * opacity / 100.0 + b.getBlue() * (1 - (opacity / 100.0));
		return new ColorPixel(red, green, blue);
	}
	private void blurPicture(Picture p,int f){
		Picture b = new PictureImpl(p.getWidth(),p.getHeight());
		for(int i =0;i<p.getHeight();i++){
			for(int j = 0;j<p.getWidth();j++){
				int left,right,up,down,area;
				double red = 0;
				double green = 0;
				double blue = 0;
				if((j-f)>=0){
					left = j-f;
				}
				else{
					left = 0;
				}
				if((j+f)<=(p.getWidth()-1)){
					right = j+f;
				}
				else{
					right = 0;
				}
				if((i-f)>=0){
					up = i-f;
				}
				else{
					up  = 0;
				}
				if((i+f)<=(p.getHeight()-1)){
					down = i+f;
				}
				else{
					down = 0;
				}
			
				area = (right-left+1)*(down-up+1);
				for(int x = up;x<=down;x++){
					for(int y = left;y<=right;y++){
						red += p.getPixel(y, x).getRed();
						green += p.getPixel(y, x).getGreen();
						blue += p.getPixel(y, x).getBlue();	
					}
				}
				b.setPixel(j, i, new ColorPixel(red/area,green/area,blue/area));
			}
		}
		
	}
}
