//Tibi
package exercicis;
import java.util.Scanner;
public class el_orden_al_carajo {

	public static void main(String[] args) {
		//Creem les variables
		Scanner sc=new Scanner(System.in);
		char [] cadena = new char [100];
		char [] cadena_aux = new char [100];
		char lletra;
		int entrada=0,sortida=100,cont_lletres=0,entrada4=0;
		boolean entrada2=true,entrada3=true;
		String paraula;
		System.out.println("Inica la frase. Acava en un #");
		paraula=sc.nextLine();
		//entrem la paraula aqui
		for (entrada=0;entrada<sortida;entrada++){
			lletra=paraula.charAt(entrada);
			cadena[entrada]=lletra;
			if (lletra=='#'){
				entrada=sortida;
			}
		}
		//Ara començarem a mirar per la ultima cosa escrita, osigui el #
		for (entrada=0;entrada<sortida;entrada++){
			cont_lletres++;
			if (cadena[entrada]=='#'){
				//Entrem en aquest bucle per reordenar la frase
				while (entrada2==true){
					//A la cadena_aux entrarem el ultim caracter la de cadena normal
					cadena_aux[entrada4]=cadena[cont_lletres];
					cont_lletres--;
					entrada4++;
					//En cuant el contador de lletres baixa al -1, sortirem
					if (cont_lletres==-1){
						entrada2=false;
					}
					
				}
				entrada=sortida;
				}
		}
		//Aqui mostrem la cadena_aux que es la que esta invertida
		for (entrada=0;entrada<sortida;entrada++){
		System.out.print(cadena_aux[entrada]);
		}
	}
		
	}

