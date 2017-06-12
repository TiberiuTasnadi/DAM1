//Tibi
//package exercicis;
import java.util.Scanner;
public class Tasnadi11 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	//La primera array va dedicada a guardar les dades dels cavalls que fiquem al principi
		double [] cadena_cavalls=new double [100];
		double cavall=0,gran;
		int entrada=0, sortida=99,llargada_cavalls=0,decisio=0;
		
		System.out.println("Introdueix les dades, no acceptem cavalls negatius, cavalls igualats a 0, cavalls superiors a 1000 i tampoc inferiors a 0.5");
	//Aqui començarem a intorudir les dades
		for (entrada=0;entrada<=sortida;entrada++){
			cavall=sc.nextDouble();
			llargada_cavalls=entrada;
	//Per sortir de l'array farem servir el -2
			if (cavall==-2){
				entrada=sortida;
			}
	//En cas de ficar un 0, algo inferior a 0, algo superior a 1000 o algo inferior a 0,5 ens obligara a tornar a escriure be.
			while((cavall==0 || cavall<0 || cavall>1000 || cavall<=0.49) && entrada!=sortida ){
				if (cavall==-2){
					entrada=sortida;
				}else{
				System.out.println("No acceptem cavalls negatius, cavalls igualats a 0, cavalls superiors a 1000 i tampoc inferiors a 0.5. Torna a introduir la dada");
				cavall=sc.nextDouble();
				}
			}
			if (entrada!=sortida){
			cadena_cavalls[entrada]=cavall;
			}
	
		}
	//Aqui comença el programa. Tenim un menu de 4 opcions. Si la nostra opcio es el 4, sortirem del programa
		while (decisio!=4){
			System.out.println("\n1. Maxim\n2.Ordenar\n3.Primers\n4.Sortida");
			decisio=sc.nextInt();
	//Si la nostra opcio es 1, mostrarem el cavall mes gran compran 1 per 1 l'array
			if (decisio==1){
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX			
				gran = MesGran(cadena_cavalls);
				System.out.println("Cavall mes Gran: "+gran);
				decisio=0;
			}
	//Si la nostra opcio es 3, mostrarem els numeros primers de la seguent forma
			if (decisio==3){
				System.out.println("Numeros Primers:");
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX			
				EsPrimer(cadena_cavalls, llargada_cavalls);
			}
	//Si la nostra decisio es 2, ordenarem l'array de 2 fores:
			if (decisio==2){
				System.out.println("1.Ascendent\n2.Descendent");
				decisio=sc.nextInt();
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX			
				Ordenar(cadena_cavalls,llargada_cavalls,decisio);
	//Aqui imprimirem la array un cop acavat el bucle de adal
				for (entrada=0;entrada<llargada_cavalls;entrada++){
					System.out.print(cadena_cavalls[entrada]+" ");
				}
			}
		}
}		

    /*
	 * Funció Ordenar.
	 * Parametres entrada:
	 * 		array de cavalls 
	 * 		quantitat de valors entrats
	 * 		si como val 1 -> Ordenació Ascendent
	 * 				val 0 -> Ordenació Descendent	 
	 * Retorna:
	 * 		void	
	 */ 	

    static  void Ordenar(double v[], int quants, int como){
    	int i,j,n;
    	double intercambio;
    	n = quants;
    	
    	if ( como == 2 ){// ordenar descendente
			for ( i = 0; i < n; i++ ){
				for ( j = 0; j < n; j++ ){
					if ( v[j] < v[i] ){
						intercambio = v[i];
						v[i] = v[j];
						v[j] = intercambio;		
					}
				}
			}
		}
    	else if ( como == 1 ){//ordenar ascendente
			for ( i = 0; i < n; i++ ){
				for ( j = 0; j < n; j++ ){
					if ( v[j] > v[i] ){
						intercambio = v[i];
						v[i] = v[j];
						v[j] = intercambio;		
					}
				}
			}
    	}
    } // Fi-Ordenar   	
    	
    
	
	
}
	