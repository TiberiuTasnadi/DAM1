/*Clase que permite leer de un archivo texto liniea a linea*/
//Importamos clases a usar
import java.io.*;
public class ex22
{
public static void main(String arg[])
{
	String NomFit = "c:/tmp/texto2.txt";
	//Creamos un String que va a contener todo el texto del archivo
     String s; 
try {
      //Abrir el fichero indicado en la variable nombreFichero
	   FileReader fr = new FileReader(NomFit);
	   BufferedReader br = new BufferedReader(fr); 
	   
	    do { 
	       s = br.readLine();
		   if (s != null) System.out.println(s); 
	   } while(s != null);
	      
	   //Cerrar el fichero
	   fr.close();
           br.close();
	   }catch(IOException e){ System.out.println("Error E/S: "+e);}
}
}