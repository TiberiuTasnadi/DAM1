//Tibi
package exercicis;
import java.util.Scanner;
public class joc {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int inicial,fin,num,num_preguntes,contador_preguntes,num2;
		// num2 es el numero que fica el jugador 2 per endevinar
		System.out.print("Indica el numero inicial \n");
		inicial=sc.nextInt();
		System.out.print("Indica el numero final \n");
		fin=sc.nextInt();
		System.out.println("Indica el numero que ha de endevinar \n");
		num=sc.nextInt();
		System.out.print("Indica el numero de pregutnes que pot fer \n");
		num_preguntes=sc.nextInt();
		System.out.print("Començem. Indica el numero, Jugador 2 \n");
		num2=sc.nextInt();
		contador_preguntes=0;
		while(contador_preguntes<num_preguntes && num2<=fin && num2>=inicial);{
			
			while(num2>num && contador_preguntes<num_preguntes){
				System.out.print("mes petit \n");
				contador_preguntes++;
				num2=sc.nextInt();
				
			}
			while(num2<num && contador_preguntes<num_preguntes){
				System.out.print("mes gran \n");
				contador_preguntes++;
				num2=sc.nextInt();
				
				}
			if(num2==num && contador_preguntes<num_preguntes){
					System.out.print("enhorabona, ho has endevinat \n");
					contador_preguntes=num_preguntes;
			}
		}
	System.out.print("Fin");
			
	}
}

