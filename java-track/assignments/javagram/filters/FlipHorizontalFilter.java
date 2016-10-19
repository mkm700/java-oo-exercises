package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class FlipHorizontalFilter implements Filter {

	public Picture process(Picture original) {
		
Picture processed = new Picture(original.width(), original.height());
        
	//get each pixel one by one
	for (int i = 0; i < original.width(); i++) {
	  for (int j = 0; j < original.height(); j++) {

		  //get color from opposite side
		  Color c = original.get(original.width()-i-1, j);

	
	      //get color components from each pixel
	      int r = c.getRed();
	      int g = c.getGreen();
	      int b = c.getBlue();
	      
	      
	      processed.set(i, j, new Color(r, g, b));
		  
	  }
	}
		
		return processed;
		
	}
}
