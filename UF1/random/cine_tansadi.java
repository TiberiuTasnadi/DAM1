//Tibi
package exercicis;
import java.util.Scanner;
public class cine {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int casos,total_gent,contador_casos=0,contador_gent=1,gent,contador_impar=1,sortida=0;
		System.out.println("Indica el numero de casos");
		casos=sc.nextInt();
		System.out.println("Indica cuanta gent hi ha a la fila");
		total_gent=sc.nextInt();
		System.out.println("Indica el numero de butaca");
		gent=sc.nextInt();
		while(sortida<1 && total_gent<10000){
			       while (gent%2!=0 && contador_casos<casos){
						System.out.println("Indica el numero de la seguent butaca");
						gent=sc.nextInt();
						contador_impar++;
						contador_gent++;
						if (total_gent==contador_gent){
							System.out.println("SI "+contador_impar);
							contador_casos++;
							contador_gent=0;
							contador_impar=0;
							if (contador_casos!=casos){
								System.out.println("Indica cuanta gent hi ha a la fila");
								total_gent=sc.nextInt();
							}else if (contador_casos==casos){
								sortida++;
							}					
						}
					}
					while (gent%2==0 && contador_casos<casos){
						contador_impar=1;
						System.out.println("Indica el numero de la seguent butaca");
						gent=sc.nextInt();
						contador_gent++;
						if (total_gent==contador_gent){
							System.out.println("NO");
							contador_casos++;
							contador_gent=1;
							if (contador_casos!=casos){
							System.out.println("Indica cuanta gent hi ha a la fila");
							total_gent=sc.nextInt();
							}else if (contador_casos==casos){
								sortida++;
							}
					
						}
						
					}
		}			
					
	}

	
}

