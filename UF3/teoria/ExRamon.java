/*Clase que permite leer de un archivo texto liniea a linea*/
//Importamos clases a usar
import java.io.*;

public class ExA
{
public static void main(String arg[])
{
	String NomFit = "c:/tmp/texto2.txt";
	int a, b,c;
	//Creamos un String que va a contener todo el texto del archivo
     a = b = c = 0;
try {
	  String s,lletra, num;
      //Abrir el fichero indicado en la variable nombreFichero
	   FileReader fr = new FileReader(NomFit);
	   BufferedReader br = new BufferedReader(fr); 
	   do { 
	       s = br.readLine();
	       if (s != null){
	              lletra  =  s.substring(0,1);
	              num = s.substring(2,s.length());
		    //System.out.println(lletra+" "+num);
		         if (lletra.equals("A")){ 
		    	//System.out.println(num+" ");
		    	a = a + Integer.parseInt(num);
		          }
		        if (lletra.equals("B")){ 
		    	//System.out.println(num+" ");
		    	b = b + Integer.parseInt(num);
		         }
		        if (lletra.equals("C")){ 
		    	//System.out.println(num+" ");
		    	c = c + Integer.parseInt(num);
		          }
		    
	       }
	   } while(s != null);
	   
	   System.out.println("A "+ a);
	   System.out.println("B "+ b);
	   System.out.println("C "+ c);
	   fr.close(); 
	   br.close();
	}catch(IOException e){ System.out.println("Error E/S: "+e);}
}
}