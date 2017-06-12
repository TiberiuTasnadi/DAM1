/*Clase que permite escribir en un archivo texto liniea a linea*/
//Importamos clases a usar
import java.io.*;
import java.util.Scanner;
public class ex11
{
public static void main(String arg[])
{
	String NomFit = "c:/tmp/texto2.txt";
	//Creamos un String que va a contener todo el texto del archivo
String texto="";
Scanner teclado = new Scanner(System.in);
try {
      
	   // true -> guarda dades al final del fitxer conservant les dades que ja hi havia
	   // false o res -> si l'arxiu existeix l'elimina i escriu el nou contingut. 
	   FileWriter fw = new FileWriter(NomFit,true);
	   //Crear un objeto BufferedWriter
	   BufferedWriter bw = new BufferedWriter(fw);
	   do
	   {
	       //Leer, por ejemplo, un texto desde el teclado
	       System.out.print("Escriba un texto: ");
	       texto = teclado.nextLine();
	       //Escrbir en el fichero el texto
	       bw.write(texto);
	       //Escribir en el fichero un salto de línea
	       bw.newLine();
	       //También se puede: bw.write("\n");
	   }while(texto.length()>0);
	   //Cerrar el buffer
	   bw.close();
	   fw.close();
	   teclado.close();
		
    }catch(IOException e){
         System.out.println("Error E/S: "+e);}
}



}