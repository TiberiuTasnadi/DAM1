//Tibi
package exercicis;
import java.util.Scanner;
public class exer_4_denambers_tasnadi {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//la seguent array es on guardarem caracter a caracter la frase que escriurem
		char [] cadena = new char [100];
		//a les seguents variables, guardarem la primera i la ultima lletra de la primera frase, per comprobar si la frase cumpleix els requisits
		char lletra_cadena,primera='a',ultima='a';
		String paraula_cadena;
		int entrada=0,sortida=100,cont_lletra=0,cont_paraules=0,bones=0,dolentes=0,cont_paraules2=0,cont_lletra2=0;;
		//Aquesta boolean la farem servir per solament registrar 1 cop la ultima lletra de la 1a paraula. Aquesta variable es tornara falsa, un cop passem la primera paraula
		boolean entrada3=true;
		System.out.println("Indica la frase. Acava amb un .");
		//Ara llegim la frase
		paraula_cadena=sc.nextLine();
		//Aqui descomosem la frase caracter a caracter i la guardem en una array. Tambe mirarem de guardar la primera i la ultima lletra a les variables corresponents
		for (entrada=0; entrada<sortida; entrada++){
			//Haurem de covnertir les majuscuels a miniscules, fent server el .toLoweCase per poder comprobar be.
			paraula_cadena=paraula_cadena.toLowerCase();
			lletra_cadena=paraula_cadena.charAt(entrada);
			
			//Aqui guardem la primera lletra just entrar dins del for
			if (entrada==0){
				primera=lletra_cadena;
			}
			//Aqui guardem la ultima lletra de la primera paraula amb l'ajuda de la boolean. Un cop fet, es torna fals i no hi passem mes per aqui
			if (lletra_cadena==' ' && entrada3==true){
				cont_lletra--;
				ultima=cadena[cont_lletra];
				entrada3=false;
			}
			//Amb aquest contador, mirarem cuantes paraules tenim
			if (lletra_cadena==' '){
				cont_paraules++;
			}
			//Aqui guardarem el character descomposat a la array
			cadena[entrada]=lletra_cadena;
			//Un cop trova el punt, es finalitza el for
			if (lletra_cadena=='.'){
				entrada=sortida;
			}
			cont_lletra++;	
		}
		cont_lletra=0;
		//igualem cont_paraules al numero que li hauria de tocar, ja que la primera paraula, dins del priemr for no la conta
		cont_paraules++;
		//Ara toca la comprobacio
		for (entrada=0; entrada<sortida; entrada++){
			//Cont_lletra sera zero sempre despres de un espai, per tal de comprobar la primera lletra
			if (cont_lletra==0){
				if(cadena[entrada]!=primera){
					//Aquest contador marca si la paraula no compleix
					dolentes++;
				}
			}
			cont_lletra++;
			//Aqui mirem si la ultima lletra compleix
			if (cadena[entrada]==' ' || cadena[entrada]=='.'){
				if(cadena[entrada-1]!=ultima){
					dolentes++;	
				}
				cont_lletra=0;
				cont_paraules2++;
			//Un cop tenim les 3 paraules analitzades, farem la comprobacio final aqui abaix
			}
			if (cont_paraules2==cont_paraules){
				//en cas de que dolentes no es un 0, significa que en algun lloc no respecta les condicions
				if (dolentes!=0){
					System.out.println("No son bones");
			//En cas de que dolentes es un 0, significa que ha passat per totes les proves i es apta		
			}else if(dolentes==0){
				System.out.println("Son bones");
			}
				//Sortim del for i del programa amb el seguent:
			entrada=sortida;
			}
			
		}
		

	}

}
