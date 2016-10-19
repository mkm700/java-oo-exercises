package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BlurFilter implements Filter {
	public Picture process(Picture original) {
	
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 1; i < original.width()-1; i++) {
	      for (int j = 1; j < original.height()-1; j++) {
	    	  //System.out.println("i: " + i + " j: " + j);
	    	  
	    	  Color c = original.get(i, j);
	    	  Color cBtm = original.get(i, j-1);
	    	  Color cTop = original.get(i, j+1);
	    	  Color cLeft = original.get(i-1, j);
	    	  Color cRight = original.get(i+1, j);
	    	  
	    	//get color components from each pixel and multiply by weight
	    	  //TODO: did not account for corners and edges - decremented loop so border not processed
	    	  //check for corners
	    	  
	    	  //check for edge
	    	  
	    	  //everything else
	    	  //TODO: changed weights to make blurrier       
	          int cr = c.getRed() * 5;
	          int cg = c.getGreen() * 5;
	          int cb = c.getBlue() * 5;
	          
	          int crBtm = cBtm.getRed() * 3;
	          int cgBtm = cBtm.getGreen() * 3;
	          int cbBtm = cBtm.getBlue() * 3;
	          
	          int crTop = cTop.getRed() * 3;
	          int cgTop = cTop.getGreen() * 3;
	          int cbTop = cTop.getBlue() * 3;
	          
	          int crLeft = cLeft.getRed() * 3;
	          int cgLeft = cLeft.getGreen() * 3;
	          int cbLeft = cLeft.getBlue() * 3;
	          
	          int crRight = cRight.getRed() * 3;
	          int cgRight = cRight.getGreen() * 3;
	          int cbRight = cRight.getBlue() * 3;
	          
	          //average to get new colors
	          int r = (int)((cr+crBtm+crTop+crLeft+crLeft)/17);
	          int g = (int)((cg+cgBtm+cgTop+cgLeft+cgRight)/17);
	          int b = (int)((cb+cbBtm+cbTop+cbLeft+cbRight)/17);
	          
	          processed.set(i, j, new Color(r, g, b));
	      }
	    }
		
		return processed;
	}
}