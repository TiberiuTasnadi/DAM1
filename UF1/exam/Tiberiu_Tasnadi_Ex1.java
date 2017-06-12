//Tibi
package exercicis;
import java.util.Scanner;
public class Tiberiu_Tasnadi_Ex1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num_toros=0, vel_toro=1, vel_corredor, vel_gran=0, cont_toros=0;
		//num_toros indica la cantitat de toros que hi han
		//vel_toro indicara la velocitat a la qual anira el toro
		//vel_corredor indicara la velocitat a la que haura de corre el corredor
		//vel_gran indicara la velocitat mes gran, per a que el corredor pugui superarla
		//cont_toros es un contador per a que el PC sapigui a quants torros ha de preguntar la velocitat
		System.out.println("Indica quants toros hi han");
		num_toros=sc.nextInt();
		//Si el num de toros es mes gran o igual a 1, la velocitat del toro es superior a 0 i no supera els 10^3 entrara al bucle
		while (num_toros>=1 && vel_toro>0 && vel_toro<1000 ){
			vel_toro=sc.nextInt();
			cont_toros++;
			//Aquest if mira si la velocitat major
			if (vel_toro>vel_gran){
				vel_gran=vel_toro;
			}
			//Final de tot, on mostra el resultat per pantalla i inicialitzo els contadors un altre cop per tornar a fer el bucle
			if (cont_toros==num_toros){
				vel_gran=vel_gran+1;
				System.out.println("El corredor irá a "+vel_gran+"Km/h");
				cont_toros=0;
				vel_gran=0;
				num_toros=sc.nextInt();
				
			}
		}
	}

}
