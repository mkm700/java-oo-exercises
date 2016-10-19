package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BrightnessFilter implements Filter {
	
	private static final double BRIGHTER = 1.4;
	
	public Picture process(Picture original) {
	
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newRed;
	          int newGreen;
	          int newBlue;
	          
	          if (r*BRIGHTER > 255) {
	        	  newRed = 255;
	          }
	          else {
	        	  newRed = (int)(r*BRIGHTER);
	          }
	          
	          if (g*BRIGHTER > 255) {
	        	  newGreen = 255;
	          }
	          else {
	        	  newGreen = (int)(g*BRIGHTER);
	          }
	          
	          if (b*BRIGHTER > 255) {
	        	  newBlue = 255;
	          }
	          else {
	        	  newBlue = (int)(b*BRIGHTER);
	          }
	          
	          
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}
}
