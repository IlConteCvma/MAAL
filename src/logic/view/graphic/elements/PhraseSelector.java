package logic.view.graphic.elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import execption.AssistantException;

public class PhraseSelector {
	
	public static String select(String from) throws AssistantException {
		String selection = null;
		Random random = new Random();
		int loop;
		

	    try (BufferedReader buffer = new BufferedReader(new FileReader(from))) {
	    	
			int i = 0; 
			loop = random.nextInt(Integer.valueOf(buffer.readLine()));
			do {
				selection=buffer.readLine();
				i++;
			
		      if(selection==null)
		        break;
		      
			}while(i<loop+1);
			
				
				buffer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new AssistantException("PhraseSelector error in file read");	
		}
		return selection;
		
	}
}
