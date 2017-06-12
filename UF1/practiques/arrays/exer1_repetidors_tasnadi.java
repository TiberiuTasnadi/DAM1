//Tibi
package exercicis;
import java.util.Scanner;
public class exer1_repetidors {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Aqui creo les variables i les arrays
		char [] cadena1 = new char [100];
		char [] cadena2 = new char [100];
		char lletra_cadena1,lletra_cadena2='a';
		String paraula_cadena1,paraula_cadena2;
		int entrada, sortida=100,entrada2=0,cont_paraules1=0,cont_paraules2=0,paraules_iguals=0;
		System.out.println("Indica les 2 frases abaix. Finalitzales amb una #");
		paraula_cadena1=sc.nextLine();
		//Ara entro caracter a caracter la paraula que he escrit dins de una array, que sera la paraula en la que farem les comprobacions		
		for (entrada=0; entrada<sortida; entrada++){
			lletra_cadena1=paraula_cadena1.charAt(entrada);
			cadena1[entrada]=lletra_cadena1;
			cont_paraules1++;
			if (lletra_cadena1=='#'){
				entrada=sortida;
				
			}
		}
		paraula_cadena2=sc.nextLine();
		//Aqui introdueixo la segona paraula caracter a caracter dins de l'array, que la fare servir per mirar els seus digits, tot el que s'ha repetit en l'anterior	
		for (entrada=0; entrada<sortida; entrada++){
			lletra_cadena2=paraula_cadena2.charAt(entrada);
			cadena2[entrada]=lletra_cadena2;
			cont_paraules2++;
			if (lletra_cadena2=='#'){
				entrada=sortida;
			}
		}
		//Un cop les 2 arrays plenes, toca mirar lletra a lletra
		while (sortida!=1){
			//Guardare la primera lletra de la segona paraula en aquesta variable
			lletra_cadena2=cadena2[entrada2];
			//Un cop guardada, mirare la 1ra array lletra a lletra si es igual que aquesta variable
			for (entrada=0;entrada<cont_paraules1;entrada++){
				if (lletra_cadena2==cadena1[entrada]){
					paraules_iguals++;
				}
			}
			//En cas de que la variable no sigui una # es mostrara per pantalla el resultat. 
			if (lletra_cadena2!='#'){
				System.out.println("Lletra "+lletra_cadena2+" -> "+paraules_iguals);
			}
			//Ara torno a reiniciar uns contadors, per tal de tornar a fer el bucle amb una lletra diferenta a l'array 2
			entrada2++;
			paraules_iguals=0;
			//Aqui, un cop tot acavat, sorirem del bucle
			if (entrada2==cont_paraules2){
				sortida=1;
			}
		}
		
	}

}
