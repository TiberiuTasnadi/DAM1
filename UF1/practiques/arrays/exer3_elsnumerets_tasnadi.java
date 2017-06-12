//Tibi
package exercicis;
import java.util.Scanner;
public class exer3_elsnumerets_tasnadi {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Aqui creo una matriu de 100x100, pero que mes endavan, fare que el usuari indique de quant ha de ser
		int [][] cadena = new int [100][100]; 
		int entrada=0,columnes=0,files=0,entrada2=0,cont_uns=0,cont_zeros=0,files_RA=0,files_dolentes=0;
		//Aqui llegire quantes files tindra la matriu
		System.out.println("Indica la cuantitat de files");
		files=sc.nextInt();
		//Aqui llegeixo quantes columes tindra la matriu
		System.out.println("Indica la cuantitat de columnes");
		columnes=sc.nextInt();
		System.out.println("Comença a indicar els valors");
		//El primer for va dedicar a intorduir els valors dins de la matriu
		for(entrada=0;entrada<files;entrada++){
			for(entrada2=0;entrada2<columnes;entrada2++){
				cadena[entrada][entrada2]=sc.nextInt();
				//Nomes es pot introduir 1,0 o 255, en cas de que no es compleix, entre en aquest bucle que obliga a ficar be el valor
				while ((cadena[entrada][entrada2]!=0) && (cadena[entrada][entrada2]!=1) && (cadena[entrada][entrada2]!=255)){
					System.out.println("Nomes pots introduir 0, 1, 255");
					cadena[entrada][entrada2]=sc.nextInt();
				}
				
			}
		}
		//Aqui imprimire la matriu per a que el usuari veigui com ha quedat
		System.out.println("La matriu queda de la seguent forma:");
		for(entrada=0;entrada<files;entrada++){
			for(entrada2=0;entrada2<columnes;entrada2++){
				System.out.print(cadena[entrada][entrada2]+" ");
				
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		//Aqui començo a analitzar i mirar si cumpleix el requesit de ser RA
		for(entrada=0;entrada<files;entrada++){
			cont_uns=0;
			cont_zeros=0;
			
			for(entrada2=0;entrada2<columnes;entrada2++){
				//En cas de que sigui un 1, pujarem el contador
				if(cadena[entrada][entrada2]==1){
					cont_uns++;
				}
				//En cas de que sigui un 0, pujarem aquest altre contador
				if(cadena[entrada][entrada2]==0){
					cont_zeros++;
				}
			}
			//Si la cantitat de 0 i 1 son iguals, pujarem el contador de files RA (osigui que si que compleix els requisits)
			if (cont_zeros==cont_uns){
				files_RA++;
				System.out.println("La fila "+(entrada+1)+" es RA");
			//En cas de que no compleix, pujem el contador de files dolentes per al final, poderlo mostrar
			}else if(cont_zeros!=cont_uns){
				files_dolentes++;
				
			}
		}
		//Un cop acavat la comprobacio, entrem al pas final, que mostrarem al usuari si es RA o no
		//En cas de  que les files_RA sigui igual al total de files que tem (osugui que totes les files son RA), mostrarem el seguent;
		if (files_RA==files){
			System.out.println("\nLa Matriu es RA ja que hi ha/n "+files_RA+" files RA i la matriu consta de "+files+" files");
		//En cas negatiu (hi han menos files_RA que files totals) mostrarem la cantitat de files que no son RA)
		}else if (files_RA!=files){
			System.out.println("La Matriu no es RA ja que sol hi ha/n "+files_RA+" filea/s RA, quant hi haurien de haver "+files);
		}
		
		
		
		
		
	}
	

}
