//Tibi
//package exercicis;
import java.util.Scanner;
public class Tasnadi_Ex2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//La primera array va dedicada a guardar les dades dels cavalls que fiquem al principi
		double [] cadena_cavalls=new double [100];
		//La segon array va dedicada a copiar la primera i guardarla aqui, quan volem ordenar-la (de aquesta forma, no modificarem la original per si decas)
		double [] cadena_secundaria=new double [100];
		double cavall,gran=0,primers=0,div=0,guardar_aux=0;
		int entrada=0, sortida=99,llargada_cavalls=0,decisio=0,cont_primers=0,mov=0,enter;
		//Aquesta entrada la farem servir per ordenar les arrays
		boolean entrada2=true;
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
				for (entrada=0;entrada<=llargada_cavalls;entrada++){
					cavall=cadena_cavalls[entrada];
					if (cavall>gran){
						gran=cavall;
					}
				}
				System.out.println("Cavall mes Gran: "+gran);
				decisio=0;
			}
			//Si la nostra opcio es 3, mostrarem els numeros primers de la seguent forma
			if (decisio==3){
				System.out.println("Numeros Primers:");
				for (entrada=0;entrada<=(llargada_cavalls-1);entrada++){
					cavall=cadena_cavalls[entrada];
					div=1;
					cont_primers=0;
					//div sera el nombre per la qual dividirem els cavalls per mirar si es impar. anira desde 0 al numero equivalent a cavall
					while (div<=cavall){
						primers=cavall/div;
						//Aqui guardarem la versio entera del nombre de la divisio, per tal de mes abaix, poder comparar si el resultat de la divisio es equivalent a ell, significa que el numero ha sigut divisible per aquell numero, en cas contrari, donara un numero decimal i no sera igual a aquest
						enter=(int) primers;
						div++;
						if (primers==enter){
							cont_primers++;
						}
					}
					//Si el numero ha sigut divisible per solament 2 numeros sera primer i entrara en aquest IF
					if (cont_primers<=2){
						System.out.print(cavall+" ");
					}
				}
			}
			//Si la nostra decisio es 2, ordenarem l'array de 2 fores:
			if (decisio==2){
				System.out.println("5.Ascendent\n6.Descendent");
				decisio=sc.nextInt();
				//Si volem ordenar Ascendentment, entrarem aqui:
				if (decisio==5){
					//Copiarem la nostra array principal a la secundaria per no alterarl-a
					for (entrada=0;entrada<llargada_cavalls;entrada++){
						cadena_secundaria[entrada]=cadena_cavalls[entrada];
					}
					entrada2=true;
					//Per ordenarla, farem que estigui tot el rato en aquest bucle:
					while (entrada2==true){
						for (entrada=0;entrada<llargada_cavalls-1;entrada++){
						//llegim digit a digit, i mirem si a la posicio seguent, es mes gran que el valor que tenim a la actual, si es aixi, intercambiarem posicions i farem servir el guardar_aux per no perdre la dada actual
							if (cadena_secundaria[entrada]>cadena_secundaria[entrada+1]){
								guardar_aux=cadena_secundaria[entrada];
								cadena_secundaria[entrada]=cadena_secundaria[entrada+1];
								cadena_secundaria[entrada+1]=guardar_aux;
							//En cas de haver fer un cambi, agumentarem el seguent contador per indicar que la array encara no esta ordenada
								mov++;
							}
						}
					//en cas de que no s'haugui fet cap moviment dins del for anterior, el contador sera =0, osigui que l'array esta ordenada. Un cop en aquesta conclusio, tornem false la boolean i sortirem del while.
						if (mov==0){
							entrada2=false;
						
						}
					//tornem a inicialitzar el contador a 0, per tal de que pugui tornar a incrementarse en cas necesari adal.
						mov=0;
						}
					//Aqui imprimirem la array un cop acavat el bucle de adal
					for (entrada=0;entrada<llargada_cavalls;entrada++){
						System.out.print(cadena_secundaria[entrada]+" ");
					}
				}
				//En cas de que volem ordenarla descendentment, farem servir el mateix metode que quan ordenem ascendentment, pero aquest cop, no mirarem si el valor de la seguent posicio es mes gran, sino mes petit.
				if (decisio==6){
					for (entrada=0;entrada<llargada_cavalls;entrada++){
						cadena_secundaria[entrada]=cadena_cavalls[entrada];
					}
					entrada2=true;
					while (entrada2==true){
						for (entrada=0;entrada<llargada_cavalls-1;entrada++){
							if (cadena_secundaria[entrada]<cadena_secundaria[entrada+1]){
								guardar_aux=cadena_secundaria[entrada];
								cadena_secundaria[entrada]=cadena_secundaria[entrada+1];
								cadena_secundaria[entrada+1]=guardar_aux;
								mov++;
							}
						}
						if (mov==0){
							entrada2=false;
						}
						mov=0;
						}
					//Ara imprimirem l'array aqui abaix:
					for (entrada=0;entrada<llargada_cavalls;entrada++){
						System.out.print(cadena_secundaria[entrada]+" ");
					}
				}
			}	

	}

}
}
