//B
//Tibi
import java.util.Scanner;
import java.util.Random;
public class tasnadi {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rnd=new Random();
		int [] parells=new int [25];
		char [] codipostal=new char [150];
		char [] numero=new char [150];
		char [] carrer=new char [150];
		char lletra;
		char [] direccio=new char[500];
		int entrada=0, sortida=25,random,valor_gran_petit,sortida1=0,vocals;
		String direc;
		//Aqui omplo l'array de randoms (punt a)
		for (entrada=0;entrada<sortida;entrada++){
			random=rnd.nextInt(20);
			//En cas de que el numero no es parell, el donem un altre
			while(random%2!=0){
				random=rnd.nextInt(21);
			}
			//En cas de que sigui inferior a 10, li sumem 10
			if (random<10){
				random=random+10;
			}
			parells[entrada]=random;
		}
		//Valro gran petit guardara el resultat de la division entre el gran i el petit(punt b)
		valor_gran_petit=CalculGran(parells);
		System.out.println("Divisio del gran i petit: "+valor_gran_petit+"\n");
		//Calcul ultim sumara el resultat del valor_gra_petit a les posicions impars(punt c)
		CalculUltim(parells,valor_gran_petit);
		//Aqui mostrarem la array com queda (punt d)
		for (entrada=0;entrada<sortida;entrada++){
			System.out.print(parells[entrada]+" ");
		}
		//Aqui preguntare la direccio del usuari i la guardare en una array anomedada direccio (punt e)
		System.out.println("\n\nIndica el carrer#codipostal#numero");
		direc=sc.nextLine();
		for (entrada=0;entrada<direc.length();entrada++){
			lletra=direc.charAt(entrada);
			direccio[entrada]=lletra;
			sortida1++;
			
		}
		//Aqui separare la informacio de la dirrecio en numero, codipostal i carrer, tambe li dono sortida1, que es el maxim del string per no llegir molt(punt f)
		Descompon(direccio, carrer, numero, codipostal,sortida1);
		//Aqui mostro el codi postal (punt g)
		System.out.println("El codi postal es: ");
		for (entrada=0;entrada<sortida1;entrada++){
			System.out.print(codipostal[entrada]);
		}
		//Aqui calculare la cantita de vocals que hi ha a l'array que he guardat el nom del carrer (punt h)
		vocals=VocalsDiferents(carrer);
		//Aqui mostrare la canitat de vocals que m'ha retornat la funcio anterior (punt i)
		System.out.println("\nVocals: "+vocals);
	}
	//Calcularem el mes gran i mes petitt i els dividirem
	public static int CalculGran(int parells2[]){
		int entrada,sortida=25,gran=0,petit,divisio;
		petit=parells2[0];
		for (entrada=0;entrada<sortida;entrada++){
			//Aqui es calculara el gran
			if (gran<parells2[entrada]){
				gran=parells2[entrada];
			}
			//Aqui el petit
			if (petit>parells2[entrada]){
				petit=parells2[entrada];
			}
		}
		divisio=gran/petit;
		return divisio;
	}
	//Aqui sumarem el valor de CalculGran a les pocisions imparelles amb valor inferior
	public static void CalculUltim(int parells2[], int valor){
		int entrada,sortida=25;
		for (entrada=0;entrada<sortida;entrada++){
			//Aqui comprovem si la posicio es imparella o no
			if (entrada%2!=0){
				//Aqui si el valor es mes gran que el que hi ha a 'larray
				if (valor>parells2[entrada]){
					parells2[entrada]=parells2[entrada]+valor;
				}
			}
		}
		
	}
	//Aqui descomposarem el sting
	public static void Descompon(char direccio[], char carrer[], char numero[], char codipostal[],int sortida){
		int entrada;
		boolean enumero=false, ecodipostal=false;
		for (entrada=0;entrada<sortida;entrada++){
			if (direccio[entrada]=='#'&& ecodipostal==false){
				ecodipostal=true;
			}else if (direccio[entrada]=='#'&& ecodipostal==true){
				enumero=true;
			}
				
			if (enumero==false && ecodipostal==false){
				carrer[entrada]=direccio[entrada];
			}
			if (ecodipostal==true && enumero==false){
				codipostal[entrada]=direccio[entrada];
			}
			if (ecodipostal==true && enumero==true){
				numero[entrada]=direccio[entrada];
			}
		}
		
	}
	//Aqui contem la cantitat de vocals
	public static int VocalsDiferents(char carrer[]){
		int entrada,sortida=50,vocals=0;
		for(entrada=0;entrada<sortida;entrada++){
			if (carrer[entrada]=='a'||carrer[entrada]=='e'||carrer[entrada]=='i'||carrer[entrada]=='o'||carrer[entrada]=='u'){
				vocals++;
			}
		}
		return vocals;
		
	}
	
	

}
