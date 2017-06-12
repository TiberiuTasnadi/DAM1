import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExFitBin {
	public static void main(String[] args) {
		String NomFit = "c:/tmp/teoria.bin";
		// Extensiones mas frecuentes de los ficheros binarios: .dat .bin
		try {
		     	EscriureFitxer(NomFit);
				LlegirFitxer(NomFit);
			
		    }catch(IOException e){
		         System.out.println("Error E/S: "+e);}
	}

	// Funcion que guarda los datos en un fichero binario
	// El orden en que se guardan los datos es muy importante para el proceso de lectura
	public static void EscriureFitxer(String Fit) throws IOException {
		try{
			DataOutputStream EscribeFichero=new DataOutputStream(new FileOutputStream(Fit, true));
            //Escribimos un entero
            EscribeFichero.writeInt(23);
           //Escribimos una cadena
            EscribeFichero.writeUTF("Fernando");
           //Escribimos un entero
            EscribeFichero.writeInt(1990);
           //Escribimos un real
            EscribeFichero.writeFloat(21.5f);
           }
		catch(IOException e){
            System.out.println("Error E/S");
        }
     }
	
	// Funcion que lee los datos de un fichero binario
	//Los datos del fichero binario se han de leer con el mismo orden en que fueran grabadas en el fichero
	public static void LlegirFitxer(String Fit) throws IOException {
		 
        try{
        	DataInputStream LeeFichero=new DataInputStream(new FileInputStream(Fit));
            
        	do{
        	//Leemos un numero y lo mostramos
            System.out.println(LeeFichero.readInt());
 
            //Leemos una cadena y lo mostramos
            System.out.println(LeeFichero.readUTF());
 
            //Leemos un numero y lo mostramos
            System.out.println(LeeFichero.readInt());
            
            //Leemos un numero y lo mostramos
            System.out.println(LeeFichero.readFloat());
        	}while(true);
        	
        }catch(EOFException e){
            //... Nos saltara este mensaje
            System.out.println("Fin del fichero");
        }catch(IOException e){
            System.out.println("Error E/S");
        }
 
    }
	
	
	
	
	
}
