//Tibi
package exercicis;
import java.util.Scanner;
public class Matriz_noroc {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Aqui creare les variables
		int [][] cadena = new int [100][100]; 
		int a_noroc=0,b_noroc=0,cont_docents=0,entrada=0,columnes=0,files=0,entrada2=0,cont_uns=0,cont_zeros=0,files_RA=0,files_dolentes=0;
		
		System.out.println("Indica la cuantitat de files");
		files=sc.nextInt();
		
		System.out.println("Indica la cuantitat de columnes");
		columnes=sc.nextInt();
		System.out.println("Comença a indicar els valors");
		//Aqui intorduieixo dins els valors
		for(entrada=0;entrada<files;entrada++){
			for(entrada2=0;entrada2<columnes;entrada2++){
				cadena[entrada][entrada2]=sc.nextInt();
				//aqui comprovo si s'han intoruit be els valors
				while ((cadena[entrada][entrada2]!=0) && (cadena[entrada][entrada2]!=1) && (cadena[entrada][entrada2]!=255)){
					System.out.println("Nomes pots introduir 0, 1, 255");
					cadena[entrada][entrada2]=sc.nextInt();
				}
				
			}
		}
		//Aqui mostro com ha quedatat la matriu
		System.out.println("La matriu queda de la seguent forma:");
		for(entrada=0;entrada<files;entrada++){
			for(entrada2=0;entrada2<columnes;entrada2++){
				System.out.print(cadena[entrada][entrada2]+" ");
				
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		
		//Aqui comnenço a comprovar:
		
		for(entrada=0;entrada<files;entrada++){
			cont_uns=0;
			cont_zeros=0;
			cont_docents=0;
			//En cas de que sigui un 1 sumarem els contadors de 1s, en cas de 0, contadors del 0 i en cas de 255 els contadors de docents
			for(entrada2=0;entrada2<columnes;entrada2++){
				
				if(cadena[entrada][entrada2]==1){
					cont_uns++;
				}
				
				if(cadena[entrada][entrada2]==0){
					cont_zeros++;
				}
				if (cadena[entrada][entrada2]==255){
					cont_docents++;
				}
			}
			//Ara comprobarem els resultats de la primera fila
			//En cas de que a la fila sol hi han 255 sera el seguents: (B)
			if (cont_uns==0 && cont_zeros==0 && cont_docents>1){
				b_noroc++;
				System.out.println("La fila "+(entrada+1)+" compleix la regla B de NOROC");
			}
			//En cas de que hi han mes 255 que 0 o 1s entrem aqui (A):
			if (cont_docents>cont_uns && cont_docents>cont_zeros){
				//Hem de vigilar que no es fusioni amb la regla B, ja que 0 es el mes petit.
				//Amb aquest ho comprovarem
				if (cont_uns!=0 || cont_zeros!=0){
				a_noroc++;
				System.out.println("La fila "+(entrada+1)+" compleix la regla A de NOROC");
				}
						
		}
		}
		//Al final mostrarem el seguent:
		//Si es compelxien les dos:
		if(a_noroc>1 && b_noroc==1){
			System.out.println("es compleixen els dos requisits, ja que hi ha mes de una fila amb el requisit A i no mes de una amb requisit B");
		//Si es compleix sol la A
		}else if (a_noroc>1){
			System.out.println("\nLa Matriu es NOROC ja que hi ha/n "+a_noroc+" files NOROC i la condicio deia que ha de tenir mes de 1a");
		//Si es compleix sol la B
		}else if (b_noroc==1){
			System.out.println("La Matriu es NOROC ja que hi han "+b_noroc+" filea/s NOROC que compleixen la B");
		//Si no es compleixen cap
		}else{
			System.out.println("no es NOROC, ja que no hi ha cap fila NOROC amb la condicio A que superi en 1 i tampoc cap fila que compelixi el requitic B, osigui sol una fila");
		}
		
		
		
		
		
	}
	

}

