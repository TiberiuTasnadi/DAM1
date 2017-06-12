//Tibi
import java.util.Scanner;
public class opcional2_tasnadi {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Aquesta cadena guardara la paraula
		char [] cadena1= new char[100];
		//Aquesta variable llegira la paraula
		String paraula;
		//Aquestos contador guardaran el numero de casos que volem per poder parar el programa
		int casos,cont_casos=0;
		//Primer pregutnarem al usuari quants casos vol
		System.out.println("Indica el numero de casos :");
		casos=sc.nextInt();
		//sc.nextLine()serveix per a que guardi el enter que es queda dins de la memoria. Si no ho fem. ho guardara al seguent nextLine i no podrem escriure una paraula
		sc.nextLine();
		//Aqui começa el bucle del programa
		do{
			//Primer de tot llegirem la paraula i la guardem al string
			System.out.println("Indica la frase/simbols");
			paraula=sc.nextLine();
			//Ara fragmentarem el stgrin dins de una array per poder comprovar 1 a 1 els caracters
			FragmentarString(paraula,cadena1);
			//Finalment comprovarem el contigut de l'array
			ComprobarArray(cadena1,paraula);
			//Agumentarem el contador de casos. En cas que sigui igual al que hem intorduit adal, pararem el bucle
			cont_casos++;
		}while(casos!=cont_casos);
	}
	//Aquesta funcio simplement introduira el string dins de una array
	public static void FragmentarString(String paraul, char cad[]){
		char lletra;
		int entrada,sortida=paraul.length();
		for (entrada=0;entrada<sortida;entrada++){
			//Partim un a un el string amb el CharAt
				lletra=paraul.charAt(entrada);
				cad[entrada]=lletra;
		}
	}
	//Aquesta funcio va dedicada a comprovar si se segueix el requeriment
	public static void ComprobarArray(char cad[],String paraul){
		int entrada,sortida=paraul.length(),cont_paren_obert=0,cont_clau_obert=0,cont_corxet_obert=0,cont_paren_tancat=0,cont_clau_tancat=0,cont_corxet_tancat=0;
		//Aqui començarem a mirar un a un el contigut
		for (entrada=0;entrada<sortida;entrada++){
			//En cas de tenir un simbol obert entrarem en aquests iff i pufarem el contador
			if (cad[entrada]=='('){
				
				cont_paren_obert++;
			}
			if (cad[entrada]=='['){
				
				cont_corxet_obert++;
			}
			if (cad[entrada]=='{'){
				
				cont_clau_obert++;
			}
			//En cas de tenir un simbol tancat, entrarem en aquest iff i pujarem el contador de tancat. Tambe miro si anteriorment he obert el simbol amb el primer if, en cas contrari, no ho mirara
			if (cad[entrada]==')'){
				if(cont_paren_obert>=1){
					cont_paren_tancat++;
				}
			}
			if (cad[entrada]==']'){
				if(cont_corxet_obert>=1){
					cont_corxet_tancat++;
				}
			}
			if (cad[entrada]=='}'){
				if(cont_clau_obert>=1){
					cont_clau_tancat++;
				}
			}
		}
		//Si hi ha la mateixa cantitat de oberts que de tancats, sortira un si, sino, sortira un NO
		if (cont_clau_obert==cont_clau_tancat&&cont_paren_obert==cont_paren_tancat&&cont_corxet_obert==cont_corxet_tancat){
			System.out.println("SI");
		}else{
			System.out.println("NO");
		}
				
	}

}
