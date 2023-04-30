package archivos;

import java.io.FileReader;
import java.io.FileWriter;

public class archivos {
public static void correr() {
	System.out.println("hola mundi");
	  try {
	    	FileWriter writer=new FileWriter("texto.txt");
	    	FileReader reader=new FileReader("texto.txt");
	    	int data=reader.read();
	    	
	    	while(data!=-1) {
	    		System.out.print((char)data);
	    		data=reader.read();
	    	}
	    	reader.close();
	    } catch (Exception e) {
	    	System.out.println("algo ocurrio mal");
	    }
}
}
