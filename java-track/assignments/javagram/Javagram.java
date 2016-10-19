package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		int choice = displayFilterMenu(in);
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		//Filter filter = getFilter(choice);			
		Filter filter = null;
		do {
			try {
				filter = getFilter(choice);
			}
			catch (RuntimeException e) {
				System.out.println("Menu number is not valid. Please try again:");
				choice = in.nextInt();
			}
		} while (filter == null);
		
		
		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		boolean exit = false;
		while (!exit){
			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
				exit = true;
			} 
			else {	
				String absFileName = dir + File.separator + fileName;
				File f = new File(absFileName);
				if(f.exists()) { 
					System.out.println("File already exists. Are you sure you want to overwrite it?");
					String response = in.next();
					if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
						processed.save(absFileName);
						System.out.println("Image saved to " + absFileName);
						exit = true;
					}
					else {
						System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
						fileName = in.next();
					}
				}
				else {
					processed.save(absFileName);
					System.out.println("Image saved to " + absFileName);
					exit = true;
				}
			}	
		}
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int choice) {
		
		// TODO - create some more filters, and add logic to return the appropriate one
		if (choice == 1) {
			return new BlueFilter();
		}
		if (choice == 2) {
			return new InvertFilter();
		}
		if (choice == 3) {
			return new BrightnessFilter();
		}
		if (choice == 4) {
			return new BlurFilter();
		}
		if (choice == 5) {
			return new GrayscaleFilter();
		}
		if (choice == 6) {
			return new FlipHorizontalFilter();
		}
		if (choice == 7) {
			return new FlipVerticalFilter();
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	private static int displayFilterMenu(Scanner in) {
		System.out.println("Choose the number of the filter you want to apply:");
		System.out.println("1. Blue Filter");
		System.out.println("2. Invert Filter");
		System.out.println("3. Brightness Filter");
		System.out.println("4. Blur Filter");
		System.out.println("5. Grayscale Filter");
		System.out.println("6. Flip Horizontal Filter");
		System.out.println("7. Flip Vertical Filter");
		
		int choice = in.nextInt();
		return choice;
	}

}