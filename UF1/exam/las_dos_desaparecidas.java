//Tibi
package exercicis;
import java.util.Scanner;
public class las_dos_desaparecidas {

	public static void main(String[] args) {
		//Aqui creem les variables i l'array
		Scanner sc=new Scanner(System.in);
		char [] cadena = new char [100];
		char lletra;
		String paraula;
		int entrada=0,sortida=40,cont_a=0,cont_e=0,cont_i=0,cont_o=0,cont_u=0;
		System.out.println("Indica la frase(no superior a 40 caracters). Acava amb un punt");
		paraula=sc.nextLine();
		//Entrem la frase dins de l'array
		for (entrada=0;entrada<sortida;entrada++){
			lletra=paraula.charAt(entrada);
			cadena[entrada]=lletra;
			if (lletra=='.'){
				entrada=sortida;
			}
			
		}
		//Pujem els contadors en cas de que siguin vocals
		for (entrada=0;entrada<sortida;entrada++){
			if (cadena[entrada]=='a'){
				cont_a++;
			}
			if (cadena[entrada]=='e'){
				cont_e++;
				
			}
			if (cadena[entrada]=='i'){
				cont_i++;
			}
			if (cadena[entrada]=='o'){
				cont_o++;
			}
			if (cadena[entrada]=='u'){
				cont_u++;
			}
			if (cadena[entrada]=='.'){
				entrada=sortida;
			}
		}
		
		//Aqui ara mostrarem les vocals mes sortides, en cas de respectar els IFS
		System.out.println("Vocal mes repetida: ");
		if (cont_a>=cont_e && cont_a>=cont_i && cont_a>=cont_o && cont_a>=cont_u){
			System.out.print(" a");
		}
		if (cont_e>=cont_a && cont_e>=cont_i && cont_e>=cont_o && cont_e>=cont_u){
			System.out.print(" e");
		}
		if (cont_i>=cont_e && cont_i>=cont_a && cont_i>=cont_o && cont_i>=cont_u){
			System.out.print(" i");
		}
		if (cont_o>=cont_e && cont_o>=cont_a && cont_o>=cont_i && cont_o>=cont_u){
			System.out.print(" o");
		}
		if (cont_u>=cont_e && cont_u>=cont_a && cont_u>=cont_o && cont_u>=cont_i){
			System.out.print(" u");
		}
		//Aqui mostrem les que menys han sortit:
		System.out.println("\nVocal menys repetida: ");
		if (cont_a<=cont_e && cont_a<=cont_i && cont_a<=cont_o && cont_a<=cont_u){
			System.out.print(" a");
		}
		if (cont_e<=cont_a && cont_e<=cont_i && cont_e<=cont_o && cont_e<=cont_u){
			System.out.print(" e");
		}
		if (cont_i<=cont_e && cont_i<=cont_a && cont_i<=cont_o && cont_i<=cont_u){
			System.out.print(" i");
		}
		if (cont_o<=cont_e && cont_o<=cont_a && cont_o<=cont_i && cont_o<=cont_u){
			System.out.print(" o");
		}
		if (cont_u<=cont_e && cont_u<=cont_a && cont_u<=cont_o && cont_u<=cont_i){
			System.out.print(" u");
		}
	}

}
