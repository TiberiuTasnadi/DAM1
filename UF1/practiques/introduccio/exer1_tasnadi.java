//Tibi
package exercicis;
import java.util.Scanner;
public class semana {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int contador_dies=1,contador_menor=0,contador_major=0;
		float suma_tot,mitjana=0,start=1,dia=0,empat_major=0,empat_menor=0,dia_ant=0,empat=0,gran=0,petit=0;
		System.out.println("Indica la guanyança dels dies de la setmana. Finalitza amb un -1 el primer dia");
		while (dia!=-1){
			//Aqui introdueixo les primeres dades i igualo que el dia petit es el dia al qual entro 1r
			if (start==1 ){
				dia=sc.nextFloat();
				start++;
				petit=dia;
			}
			//Aqui miro si el dia introduit es mes gran i si no es passa del contador de dies
			while (dia>gran && contador_dies<6 && dia!=1){
				mitjana=mitjana+dia;
				gran=dia;			
				dia_ant=dia;
				contador_major=contador_dies;				
				dia=sc.nextFloat();			
				contador_dies++;						
			}
			//Aqui miro si el dia introduit es mes petit i si no es passa del contador de dies
			while (dia<petit && contador_dies<6 && dia!=1){
				mitjana=mitjana+dia;				
				petit=dia;
				dia_ant=dia;
				contador_menor=contador_dies;				
				dia=sc.nextFloat();				
				contador_dies++;						
			}
			// Aqui miro si hi ha algun empat entre dies, i si es aixi, mirar si el empat esta entre numeros grans o petits
			while (dia==dia_ant && gran==dia_ant && contador_dies<6 && dia!=1 ){
				empat_major=dia;
				dia=dia_ant;
				dia=sc.nextFloat();			
				contador_dies++;				
				mitjana=mitjana+dia;
			}
			while (dia==dia_ant && petit==dia_ant && contador_dies<6 && dia!=1){
					empat_menor=dia;
					dia=dia_ant;				
					dia=sc.nextFloat();					
					contador_dies++;			
					mitjana=mitjana+dia;
			}		
			// Ja començo a mostrar per pantalla els resultats aqui
			while (contador_dies==6){
				mitjana=mitjana/6;
				if (dia>gran){
					gran=dia;
				}
				if (dia<petit){
					petit=dia;
				}
				if (dia==dia_ant && petit==dia_ant){
					empat_menor=dia;
				}
				if (dia==dia_ant && gran==dia_ant){
					empat_major=dia;
				}
				//Aqui si els 2 son empats
				if (mitjana<dia && gran==empat_major && petit==empat_menor){
					System.out.println("EMPAT EMPAT SI");
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					dia_ant=0;
					empat=0;
					contador_menor=0;
					contador_major=0;
					start=1;
					dia=sc.nextFloat();
				}else if (mitjana>dia && gran==empat_major && petit==empat_menor){
					System.out.println("EMPAT EMPAT NO");
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					dia_ant=0;
					empat=0;
					start=1;
					contador_menor=0;
					contador_major=0;
					dia=sc.nextFloat();
				// Aqui si el empat esta entre els numeros grans
				}else if (mitjana<dia && gran==empat_major && petit!=empat_menor){
					if (contador_menor==1){
						System.out.println("EMPAT DIMARTS SI");
					}
					if (contador_menor==2){
						System.out.println("EMPAT DIMECRES SI");
					}
					if (contador_menor==3){
						System.out.println("EMPAT DIJOUS SI");
					}
					if (contador_menor==4){
						System.out.println("EMPAT DIVENDRES SI");
					}
					if (contador_menor==5){
						System.out.println("EMPAT DISSABTE SI");
					}
					if (contador_menor==6){
						System.out.println("EMPAT DIUMENGE SI");
					}					
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					dia_ant=0;
					start=1;
					empat=0;
					contador_menor=0;
					contador_major=0;
					dia=sc.nextFloat();
				}else if (mitjana>dia && gran==empat_major && petit!=empat_menor){
					if (contador_menor==1){
						System.out.println("EMPAT DIMARTS NO");
					}
					if (contador_menor==2){
						System.out.println("EMPAT DIMECRES NO");
					}
					if (contador_menor==3){
						System.out.println("EMPAT DIJOUS NO");
					}
					if (contador_menor==4){
						System.out.println("EMPAT DIVENDRES NO");
					}
					if (contador_menor==5){
						System.out.println("EMPAT DISSABTE NO");
					}
					if (contador_menor==6){
						System.out.println("EMPAT DIUMENGE NO");
					}
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					dia_ant=0;
					empat=0;
					start=1;
					contador_menor=0;
					contador_major=0;
					dia=sc.nextFloat();
				// Aqui si el empat esta entre numeros petits
				}else if (mitjana>dia && petit==empat_menor && gran!=empat_major){
					
					if (contador_major==1){
						System.out.println("DIMARTS EMPAT NO");
					}
					if (contador_major==2){
						System.out.println("DIMECRES EMPAT NO");
					}
					if (contador_major==3){
						System.out.println("DIJOUS EMPAT NO");
					}
					if (contador_major==4){
						System.out.println("DIVENDRES EMPAT NO");
					}
					if (contador_major==5){
						System.out.println("DISSABTE EMPAT NO");
					}
					if (contador_major==6){
						System.out.println("DIUMENGE EMPAT NO");
					}
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					dia_ant=0;
					empat=0;
					contador_menor=0;
					start=1;
					contador_major=0;
					dia=sc.nextFloat();
				}else if (mitjana<dia && petit==empat_menor && gran!=empat_major){
					
					if (contador_major==1){
						System.out.println("DIMARTS EMPAT SI");
					}
					if (contador_major==2){
						System.out.println("DIMECRES EMPAT SI");
					}
					if (contador_major==3){
						System.out.println("DIJOUS EMPAT SI");
					}
					if (contador_major==4){
						System.out.println("DIVENDRES EMPAT SI");
					}
					if (contador_major==5){
						System.out.println("DISSABTE EMPAT SI");
					}
					if (contador_major==6){
						System.out.println("DIUMENGE EMPAT SI");
					}
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					dia_ant=0;
					empat=0;
					start=1;
					contador_menor=0;
					contador_major=0;
					dia=sc.nextFloat();
				//I per acabar, en cas de que no hi ha cap empat, mostrat el dia mes gran i em mes petit segons els contadors
				}else if (mitjana<dia && gran!=empat_major && petit!=empat_menor){
					
					if (contador_major==1){
						System.out.print("Dimarts  ");
					}
					if (contador_major==2){
						System.out.print("Dimecres  ");
					}
					if (contador_major==3){
						System.out.print("Dijous  ");
					}
					if (contador_major==4){
						System.out.print("Divendres  ");
					}
					if (contador_major==5){
						System.out.print("Dissabte  ");
					}
					if (contador_major==6){
						System.out.print("Diumenge  ");
					}
					if (contador_menor==1){
						System.out.print("Dimarts  SI");
					}
					if (contador_menor==2){
						System.out.print("Dimecres  SI");
					}
					if (contador_menor==3){
						System.out.print("Dijous  SI");
					}
					if (contador_menor==4){
						System.out.print("Divendres  SI");
					}
					if (contador_menor==5){
						System.out.print("Dissabte  SI");
					}
					if (contador_menor==6){
						System.out.print("Diumenge  SI");
					}
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					start=1;
					dia_ant=0;
					empat=0;
					contador_menor=0;
					contador_major=0;
					dia=sc.nextFloat();
				}else if (mitjana>dia && gran!=empat_major && petit!=empat_menor){
					
					if (contador_major==1){
						System.out.print("Dimarts  ");
					}
					if (contador_major==2){
						System.out.print("Dimecres  ");
					}
					if (contador_major==3){
						System.out.print("Dijous  ");
					}
					if (contador_major==4){
						System.out.print("Divendres  ");
					}
					if (contador_major==5){
						System.out.print("Dissabte  ");
					}
					if (contador_major==6){
						System.out.print("Diumenge  ");
					}
					if (contador_menor==1){
						System.out.print("Dimarts  NO");
					}
					if (contador_menor==2){
						System.out.print("Dimecres  NO");
					}
					if (contador_menor==3){
						System.out.print("Dijous  NO");
					}
					if (contador_menor==4){
						System.out.print("Divendres  NO");
					}
					if (contador_menor==5){
						System.out.print("Dissabte  NO");
					}
					if (contador_menor==6){
						System.out.print("Diumenge  NO");
					}
					contador_dies=1;
					mitjana=0;
					gran=0;
					petit=0;
					suma_tot=0;
					dia_ant=0;
					start=1;
					empat=0;
					contador_menor=0;
					contador_major=0;
					dia=sc.nextFloat();
				}
			}	
		}
		

	}

}
