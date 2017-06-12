//Tibi
import java.util.Scanner;
public class opcional1 {
	public static void main(String[] args) {
		//La cadena1 es la array on guardem tot
		double [] cadena1 = new double[100];
		//notafinal es el resultat que mostrarem al final
		double notafinal;
		//Aquests es un cotnador i el numero de casos que vull donar
		int casos,cont_casos=0;
		Scanner sc=new Scanner(System.in);
		//Primer llegirem el numero de casos que volem
		System.out.println("Indica el numero de casos");
		casos=sc.nextInt();
		//Aqui comença tot, mentres cont_casos no sigui igual a casso executarem el while, de tal forma que sempre que acava una volta el incrementem i tornem a comprovar
		do{
			//Primer de tot farem una funcio de omplir la array de les notes que volem
			OmplirArray(cadena1);
			//Un cop entrades, les ordenarem de mes petita a mes gran
			OrdenarArray(cadena1);
			//per acabar, guardarem dins d'aquesta variable la suma i la multipicacio
			notafinal=MultiplicarArray(cadena1);
			System.out.println("Nota final: "+notafinal);
			//Incrementem, ja que hem acavat un cas
			cont_casos++;
		}while(cont_casos!=casos);

	}
	//Aquesta funcio va dedicada a omplir la array
	public static void OmplirArray(double cad[]){
		Scanner sc=new Scanner(System.in);
		int entrada, sortida=7;
		double dada;
		System.out.println("Indica les notes");
		for (entrada=0;entrada<sortida;entrada++){
			//Llegeixo la dada aqui
			dada=sc.nextFloat();
			while (dada%0.5!=0||dada>10){
				//Aqui comprova si la dada es un enter o un mig. En cas contrari, haurem de tornar a introduir la nota
				System.out.println("sol poden ser enters o mitjos i no pot passar del 10");
				dada=sc.nextFloat();
				
			}
			//Si  tot ha anat be, guardarem la dada aqui
			cad[entrada]=dada;
		}
	}
	//Aquesta funcio va dedicada a ordenar la array
	public static void OrdenarArray(double cad[]){
		int i,j,n=7;
    	double intercambio;
		for ( i = 0; i < n; i++ ){
			for ( j = 0; j < n; j++ ){
				if ( cad[j] <cad[i] ){
					intercambio = cad[i];
					cad[i] = cad[j];
					cad[j] = intercambio;		
				}
			}
		}
	}
	//Aquesta funcio guardara el resultat final
	public static double MultiplicarArray(double cad[]){
		double cd=2,fin=0;
		Scanner sc=new Scanner(System.in);
		//com que hem ordenat la array i a nosaltres no ens interesen els primers 2 ni els ultism 2, podem selecionarlos aixi
		fin=(cad[2]+cad[3]+cad[4])*cd;
		return fin;
	}

}
