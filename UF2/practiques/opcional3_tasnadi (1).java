//Tibi
import java.util.Scanner;
public class opcional3_tasnadi {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Dins de cadena guardarem els numeros
		int [][] cadena = new int [50][50];
		//Aquestes variables guarden contadors, el numero de casos i la cantitat de numeros que hi ha a al mediatriu
		int casos,cont_casos=0,sortida1;;
		//Mirem quants casos vol el usuari
		System.out.println("Indica el numero de casos");
		casos=sc.nextInt();
		//Aqui comença el bucle mentres els casos sigui difenret al cotnador que casos, que incrementa quan acava una volta al bucle
		do{
			//Primer omplirem la mediatriu i retornarem la cantitat de numeros que hem introduir
			sortida1=OmplirMatriu(cadena);
			//Mostrerem la mediatriu al usuari
			MostrarMatriu(cadena,sortida1);
			//Comprovarem la mediatiu i mostrarem si es o no triangular
			ComprovarMatriu(cadena,sortida1);
			//Agumtnem el cotador, ja que hem fet una volta
			cont_casos++;
			
		}while(casos!=cont_casos);
	}
	//Aquesta funcio omplira la mediatiriu u retornara la cantitat de numeros que hi han
	public static int OmplirMatriu(int cad[][]){
		Scanner sc=new Scanner(System.in);
		int sortida,entrada1=0,entrada2=0,numero;
		System.out.println("La Matriu es quadrada. Indica el numero de files/columnes(no pot ser superior a 50 ni inferior a 2)");
		//Aqui llegirem la cantita de numeros que hi hauran
		sortida=sc.nextInt();
		//En cas de que es inferior a 2 o superior a 50, tornara a preguntar i a llegir
		while (sortida<2 || sortida>50){
			System.out.println("no pot ser superior a 50 ni inferior a 2");
			sortida=sc.nextInt();
		}
		System.out.println("Indica els numeros");
		//Ara guardarem numeros dins de la matriu
		for (entrada1=0;entrada1<sortida;entrada1++){
			for (entrada2=0;entrada2<sortida;entrada2++){
				numero=sc.nextInt();
				cad[entrada1][entrada2]=numero;
			}
		}
		//Retornarem la cantitat de numeros que hi ha, ja que ho nececitarem en altres funcions
		return sortida;
	}
	//Aqusta funcio va dedicada a mostrar per pantalla com ha quetat la matriu
	public static void MostrarMatriu(int cad[][],int sortida){
		int entrada1=0,entrada2=0;
		System.out.println("\n");
		for (entrada1=0;entrada1<sortida;entrada1++){
			for (entrada2=0;entrada2<sortida;entrada2++){
				System.out.print(cad[entrada1][entrada2]+"\t");
			}
			System.out.print("\n");
		}
		
	}
	//Aquesta funcio va dedicada a comprovar la triagularitat de la matriu
	public static void ComprovarMatriu(int cad[][],int sortida){
		//cont_zero_inf, contara els zeros de la part inferior de la matriu i lloc1, quants cops ho ha llegit. Igual passa amb cont_zero_sup i lloc2
		int entrada1=0,entrada2=0,cont_zeros_inf=0,cont_zeros_sup=0,lloc1=0,lloc2=0,aux_sortida,entrada3=0;
		//Aux sortida guardara de quant es la mediatiriu, pero restara 1, ja que les pocisions van de 0 a X
		aux_sortida=(sortida-1);
		//Aqui comprovo la part de baix de la mediatriu
		//Començare mirant la ultima fila i el penultim numero. ja que el ultim sempre va dedicat a la mediatriu
		for (entrada1=(sortida-1);entrada1>=0;entrada1--){
			aux_sortida--;
				for(entrada2=aux_sortida;entrada2>=0;entrada2--){
					//En cas de 0, pujare el contador
				if (cad[entrada1][entrada2]==0){
					cont_zeros_inf++;
				}
				//aqui guardo la cantitat de numeros que llegeixo
				lloc1++;
			}
			//Un cop mirada una fila, pujo a la superior, pero ignorare la part superior i la mediatriu, restant al aux_sortida
		}
		//Ara llegirem la part superior
		//Primer mirarem la primera fila i el segona posicio, ja que la primera va dedicada a la mediatriu
		for (entrada1=0;entrada1<sortida;entrada1++){
			entrada3++;
			for(entrada2=entrada3;entrada2<sortida;entrada2++){
				//En cas de 0 pujare el contador
				if (cad[entrada1][entrada2]==0){
					cont_zeros_sup++;
				}
				//Aqui guardo la cantitat de numeros que llegeixo
				lloc2++;
			}
			//Un cop mirada la fila, baixo a la inferior i mirare la seguent posicio de la mediatriu, ja que aquest cop ha pujat un ella incrementant entrada3
		}
		//En cas de lloc(cantitat de numeros que he llegit) es igual a la cantitat de zeros que hi han, donara un SI, en cas cotnrari donara NO
		if (lloc1==cont_zeros_inf || lloc2==cont_zeros_sup){
			System.out.println("SI");
		}else{
			System.out.println("NO");
		}
		
	}
	
}
